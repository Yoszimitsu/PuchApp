package pl.puch.puchapp.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.puch.puchapp.dto.cepikClient.CepikVehiclesListDTO;
import pl.puch.puchapp.dto.cepikClient.CepikVehiclesSearchFilter;
import pl.puch.puchapp.service.rest.CepikRestClient;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static pl.puch.puchapp.common.CepikApiConstants.QUERY_DATE_CLIENT_FORMAT;

@Service
@Slf4j
public class CepikService {

    @Autowired
    private CepikRestClient cepikRestClient;

    public CepikVehiclesListDTO getCepikVehiclesList(LocalDate dateFrom, LocalDate dateTo, String voivodeshipCode, Integer limit, Integer page) {
        log.info("getCepikVehiclesList() start - dateFrom={}, dateTo={}, voivodeshipCode={}, limit={}, page={}", dateFrom, dateTo, voivodeshipCode, limit, page);

        CepikVehiclesSearchFilter searchFilter = createSearchFilter(dateFrom, dateTo, voivodeshipCode, limit, page);
        log.info("generated search filter: {}", searchFilter);

        CepikVehiclesListDTO cepikVehicles = cepikRestClient.callGetCepikVehiclesList(searchFilter);

        log.info("getCepikVehiclesList() end");
        return cepikVehicles;
    }

    private CepikVehiclesSearchFilter createSearchFilter(LocalDate dateFrom, LocalDate dateTo, String voivodeshipCode, Integer limit, Integer page) {
        String formattedDateFrom = Optional.ofNullable(dateFrom)
                .map(date -> date.format(DateTimeFormatter.ofPattern(QUERY_DATE_CLIENT_FORMAT)))
                .orElse(null);
        String formattedDateTo = Optional.ofNullable(dateTo)
                .map(date -> date.format(DateTimeFormatter.ofPattern(QUERY_DATE_CLIENT_FORMAT)))
                .orElse(null);

        return CepikVehiclesSearchFilter.builder()
                .dateFrom(formattedDateFrom)
                .dateTo(formattedDateTo)
                .voivodeshipCode(voivodeshipCode)
                .limit(limit)
                .page(page)
                .build();
    }
}
