package pl.puch.puchapp.forest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ForestDto {
    private long forestId;
    private Integer xWgs84;
    private Integer yWgs84;
    private Integer xPl2000;
    private Integer tPl2000;
    private Integer partId;
    private String district;
    private String forestArea;
    private String estate;
    private Double forestDepartamentId;
    private Double area;
    private String forestType;
    private Double ecosystemArea;
    private String treeSpecies;
    private String treeSpeciesArea;
    private String valuation;
    private Double age;
    private String treesPercentage;
    private String forestCompactness;
    private String forestMixed;
    private String brushwood;
    private String undercoat;
    private String planType;
    private String plan;
    private String planTime;
    private Double shapeArea;
    private Double shapeLength;
}
