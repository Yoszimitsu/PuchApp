package pl.puch.puchapp.controller;

import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.puch.puchapp.dto.cepikClient.CepikVehiclesListDTO;
import pl.puch.puchapp.service.CepikService;

import java.time.LocalDate;

@RestController
@RequestMapping("/cepik")
public class CepikController {

    @Autowired
    private CepikService cepikService;

    @GetMapping("/vehicles")
    public CepikVehiclesListDTO getCepikVehiclesList(
            @RequestParam
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @ApiParam(example = "2018-04-20")
                    LocalDate dateFrom,
            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
            @ApiParam(example = "2018-04-21")
                    LocalDate dateTo,
            @RequestParam
            @ApiParam(example = "14")
                    String voivodeshipCode,
            @RequestParam(required = false)
            @ApiParam(example = "50")
                    Integer limit,
            @RequestParam(required = false)
            @ApiParam(example = "1")
                    Integer page) {
        return cepikService.getCepikVehiclesList(dateFrom, dateTo, voivodeshipCode, limit, page);
    }
}
