package pl.puch.puchapp.forest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ForestRequestDto {

    @NotBlank(message = "ResourceId must not be blank.")
    private String resourceId;
    private String query;
    private String limit;
    private String offset;
}

