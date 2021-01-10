package pl.puch.puchapp.forest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ForestRequestDto {

    private String requestId;
    private String query;
    private String limit;
    private String offset;

    public static ForestRequestDto mapRequestParamsToForestRequestDto(ForestRequestDto forestRequestDto, Map<String, String> requestParams) {
        Optional.ofNullable(requestParams.get("resource_id")).map(requestId -> forestRequestDto.requestId = requestId);
        Optional.ofNullable(requestParams.get("q")).map(query -> forestRequestDto.query = query);
        Optional.ofNullable(requestParams.get("limit")).map(limit -> forestRequestDto.limit = limit);
        Optional.ofNullable(requestParams.get("offset")).map(offset -> forestRequestDto.offset = offset);
        return forestRequestDto;
    }
}

