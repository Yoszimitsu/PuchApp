package pl.puch.puchapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.puch.puchapp.dto.cepikClient.CepikVehiclesListDTO;


@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/test")
    public CepikVehiclesListDTO test(){

        CepikVehiclesListDTO result = restTemplate.getForObject("https://api.cepik.gov.pl/pojazdy?wojewodztwo=14&data-od=20180101&data-do=20180101", CepikVehiclesListDTO.class);
        return result;
    }



}
