package pl.puch.puchapp.forest.services.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.puch.puchapp.forest.dto.ForestDto;
import pl.puch.puchapp.forest.dto.ForestRequestDto;
import pl.puch.puchapp.forest.dto.ForestResponseDto;
import pl.puch.puchapp.forest.errors.JsonResponseException;
import pl.puch.puchapp.forest.errors.JsonResponseParserException;

import java.util.List;
import java.util.Optional;

import static pl.puch.puchapp.forest.common.ForestApiConstants.*;

@Service
@Slf4j
public class ForestRestClientService {

    @Autowired
    private RestTemplate restTemplate = new RestTemplate();
    private ForestResponseDto forestResponseDto = new ForestResponseDto();

    public ForestResponseDto sendRequestToForestApi(ForestRequestDto request) throws JsonResponseParserException {
        log.info("sendRequestToForestApi() start");
        String url = getApiUrl(request);
        log.info("generated url: {}", url);

        JsonNode response = restTemplate.getForObject(url, JsonNode.class);
        forestResponseDto = parseResponse(response, forestResponseDto);

        log.info("sendRequestToForestApi() end - result size: {}", forestResponseDto.getForestData().size());
        return forestResponseDto;
    }

    private String getApiUrl(ForestRequestDto request) {
        return UriComponentsBuilder
                .fromHttpUrl(API_UM_URL)
                .path(API_UM_DATASTORE)
                .queryParam(FOREST_RESOURCE_ID, request.getResourceId())
                .queryParamIfPresent(FOREST_QUERY_PARAM_LIMIT, Optional.ofNullable(request.getLimit()))
                .queryParamIfPresent(FOREST_QUERY_PARAM_QUERY, Optional.ofNullable(request.getQuery()))
                .build()
                .toString();
    }

    private ForestResponseDto parseResponse(JsonNode response, ForestResponseDto forestResponseDto) throws JsonResponseParserException {
        ObjectMapper mapper = new ObjectMapper();
        try {
            if (response != null && !response.has("error")) {
                JsonNode result = response.get("result");

                if (result.has("records") && result.get("records").isArray()) {
                    forestResponseDto.setForestData(mapper.readValue(result.get("records").toPrettyString(), new TypeReference<List<ForestDto>>() {}));
                }
                if (result.has("_links")) {
                    forestResponseDto.setLinks(result.get("_links"));
                }
                if (result.has("total")) {
                    forestResponseDto.setTotal(result.get("total").asInt());
                }
            } else {
                throw new JsonResponseException(response.get("error").toString());
            }
        } catch (Exception e) {
            throw new JsonResponseParserException("Error during JSON response processing. Error message: " + e.getMessage());
        }
        return forestResponseDto;
    }
}
