package pl.puch.puchapp.controller;

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
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateFrom,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate dateTo,
            @RequestParam String voivodeshipCode,
            @RequestParam(required = false) Integer limit,
            @RequestParam(required = false) Integer page){
        return cepikService.getCepikVehiclesList(dateFrom, dateTo, voivodeshipCode, limit, page);
    }


}
