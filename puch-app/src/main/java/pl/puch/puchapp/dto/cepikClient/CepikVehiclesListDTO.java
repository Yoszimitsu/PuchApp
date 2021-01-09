package pl.puch.puchapp.dto.cepikClient;

import lombok.Data;

import java.util.List;

@Data
public class CepikVehiclesListDTO {
    private List<CepikVehicleDTO> data;
}
