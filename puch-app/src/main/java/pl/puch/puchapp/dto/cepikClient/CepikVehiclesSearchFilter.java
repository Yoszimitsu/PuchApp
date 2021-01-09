package pl.puch.puchapp.dto.cepikClient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CepikVehiclesSearchFilter {
    private String voivodeshipCode;
    private String dateFrom;
    private String dateTo;
    private Integer limit;
    private Integer page;
}
