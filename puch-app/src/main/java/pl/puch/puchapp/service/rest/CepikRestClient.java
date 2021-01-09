package pl.puch.puchapp.service.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.puch.puchapp.dto.cepikClient.CepikVehiclesListDTO;
import pl.puch.puchapp.dto.cepikClient.CepikVehiclesSearchFilter;

import java.util.List;
import java.util.Optional;

import static pl.puch.puchapp.common.CepikApiConstants.*;

// https://api.cepik.gov.pl/doc
@Service
@Slf4j
public class CepikRestClient {

    @Autowired
    private RestTemplate restTemplate;

    public CepikVehiclesListDTO callGetCepikVehiclesList(CepikVehiclesSearchFilter filter) {
        log.info("callGetCepikVehiclesList() start");

        String url = getApiUrl(filter);
        log.info("generated url: {}", url);

        CepikVehiclesListDTO result = restTemplate.getForObject(url, CepikVehiclesListDTO.class);

        Integer resultSize = Optional.ofNullable(result)
                .map(CepikVehiclesListDTO::getData)
                .map(List::size)
                .orElse(null);

        log.info("callGetCepikVehiclesList() end - result size: {}", resultSize);
        return result;
    }

    private String getApiUrl(CepikVehiclesSearchFilter filter) {
        return UriComponentsBuilder
                .fromHttpUrl(CEPIK_API_URL)
                .path(CEPIK_API_PATH_VEHICLES)
                .queryParam(QUERY_PARAM_VOIVODESHIP_CODE, filter.getVoivodeshipCode())
                .queryParam(QUERY_PARAM_DATE_FROM, filter.getDateFrom())
                .queryParamIfPresent(QUERY_PARAM_DATE_TO, Optional.ofNullable(filter.getDateTo()))
                .queryParamIfPresent(QUERY_PARAM_LIMIT, Optional.ofNullable(filter.getLimit()))
                .queryParamIfPresent(QUERY_PARAM_PAGE, Optional.ofNullable(filter.getPage()))
                .build()
                .toString();
    }
}
