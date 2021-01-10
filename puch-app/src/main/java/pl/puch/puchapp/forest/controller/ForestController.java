package pl.puch.puchapp.forest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.puch.puchapp.forest.dto.ForestResponseDto;
import pl.puch.puchapp.forest.errors.JsonResponseParserException;
import pl.puch.puchapp.forest.services.ForestService;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping(ForestController.FOREST_REQUEST_MAPPING)
@RequiredArgsConstructor
@Slf4j
public class ForestController {

    static final String FOREST_REQUEST_MAPPING = "/forest";
    private final ForestService forestService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ForestResponseDto get(@Valid @RequestParam Map<String, String> forestParams) throws JsonResponseParserException, JsonProcessingException {
        log.info("GET " + FOREST_REQUEST_MAPPING);
        return forestService.getForestResponseDto(forestParams);
    }
}
