package pl.puch.puchapp.dto.cepikClient;

import lombok.Data;

@Data
public class CepikVehicleDTO {
    private String id;
    private String type;
    private CepikVehicleAttributesDTO attributes;
    private CepikLinksDTO links;
}
