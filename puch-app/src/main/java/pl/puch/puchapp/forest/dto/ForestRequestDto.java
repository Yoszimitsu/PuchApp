package pl.puch.puchapp.forest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ForestRequestDto {

    private String resourceId;
    private String query;
    private String limit;
    private String offset;
}

