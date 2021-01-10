package pl.puch.puchapp.forest.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.puch.puchapp.forest.dto.ForestRequestDto;
import pl.puch.puchapp.forest.dto.ForestResponseDto;
import pl.puch.puchapp.forest.errors.JsonResponseParserException;
import pl.puch.puchapp.forest.services.rest.ForestRestClient;

@Service
@Slf4j
public class ForestService {

    @Autowired
    private ForestRestClient forestRestClient;
    private ForestRequestDto forestRequestDto;

    public ForestResponseDto getForestResponseDto(String resourceId, String limit, String q, String offset) throws JsonResponseParserException {
        log.info("getForestResponseDto() start - resourceId={}, limit={}, q={}, offset={}", resourceId, limit, q, offset);

        forestRequestDto = ForestRequestDto.builder()
                .resourceId(resourceId)
                .limit(limit)
                .query(q)
                .offset(offset)
                .build();
        ForestResponseDto forestResponseDto = forestRestClient.sendRequestToForestApi(forestRequestDto);

        log.info("getForestResponseDto() end");
        return forestResponseDto;
    }
}
