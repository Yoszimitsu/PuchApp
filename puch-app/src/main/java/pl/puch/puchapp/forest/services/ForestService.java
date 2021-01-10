package pl.puch.puchapp.forest.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.puch.puchapp.forest.dto.ForestRequestDto;
import pl.puch.puchapp.forest.dto.ForestResponseDto;
import pl.puch.puchapp.forest.errors.JsonResponseParserException;
import pl.puch.puchapp.forest.services.rest.ForestRestClient;

import java.util.Map;

import static pl.puch.puchapp.forest.dto.ForestRequestDto.mapRequestParamsToForestRequestDto;

@Service
@Slf4j
public class ForestService {

    @Autowired
    private ForestRestClient forestRestClient;
    private ForestRequestDto forestRequestDto;

    public ForestResponseDto getForestResponseDto(Map<String, String> forestRequestParams) throws JsonResponseParserException {
        log.info("getForestResponseDto() start - requestParams{}", forestRequestParams.values());

        forestRequestDto = new ForestRequestDto();
        forestRequestDto = mapRequestParamsToForestRequestDto(forestRequestDto, forestRequestParams);
        ForestResponseDto forestResponseDto = forestRestClient.sendRequestToForestApi(forestRequestDto);

        log.info("getForestResponseDto() end");
        return forestResponseDto;
    }
}
