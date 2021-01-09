package pl.puch.puchapp.dto.cepikClient;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CepikVehicleAttributesDTO {
    @JsonAlias("marka")
    private String brand;

    @JsonAlias("kategoria-pojazdu")
    private String vehicleCategory;

    @JsonAlias("typ")
    private String type;

    @JsonAlias("model")
    private String model;

    @JsonAlias("wariant")
    private String variant;

    @JsonAlias("rodzaj-pojazdu")
    private String vehicleType;

    @JsonAlias("pochodzenie-pojazdu")
    private String vehicleOrigin;

    @JsonAlias("rok-produkcji")
    private String productionYear;

    @JsonAlias("data-pierwszej-rejestracji-w-kraju")
    private LocalDate firstRegistrationDate;

    @JsonAlias("pojemnosc-skokowa-silnika")
    private Integer engineCubicCapacity;

    @JsonAlias("masa-wlasna")
    private Integer curbWeight;

    @JsonAlias("rodzaj-paliwa")
    private String fuelType;

    @JsonAlias("wojewodztwo-kod")
    private String voivodeshipCode;
}
