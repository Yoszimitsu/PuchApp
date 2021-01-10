package pl.puch.puchapp.forest.dto;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ForestResponseDto {

    private List<ForestDto> forestData;
    private JsonNode links;
    private int total;
}
