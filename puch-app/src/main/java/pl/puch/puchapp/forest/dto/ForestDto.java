package pl.puch.puchapp.forest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ForestDto {
    @JsonProperty("_id")
    private long forestId;
    @JsonProperty("x_wgs84")
    private Integer xWgs84;
    @JsonProperty("y_wgs84")
    private Integer yWgs84;
    @JsonProperty("x_pl2000")
    private Integer xPl2000;
    @JsonProperty("y_pl2000")
    private Integer tPl2000;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("partid")
    private Integer partId;
    @JsonProperty("dzielnica")
    private String district;
    @JsonProperty("obwód")
    private String forestArea;
    @JsonProperty("osiedle")
    private String estate;
    @JsonProperty("nr_oddz")
    private String forestDepartamentId;
    @JsonProperty("poddz")
    private String subDepartment;
    @JsonProperty("powierzchnia")
    private String area;
    @JsonProperty("stl")
    private String forestType;
    @JsonProperty("powierzchnia1")
    private String ecosystemArea;
    @JsonProperty("gat_panujacy")
    private String treeSpecies;
    @JsonProperty("udział")
    private String treeSpeciesArea;
    @JsonProperty("wiek")
    private Double age;
    @JsonProperty("bonitacja")
    private String valuation;
    @JsonProperty("zadrzewienie")
    private String treesPercentage;
    @JsonProperty("zwarcie")
    private String forestCompactness;
    @JsonProperty("zmieszanie")
    private String forestMixed;
    @JsonProperty("podrost")
    private String undercoat;
    @JsonProperty("podszyt")
    private String brushwood;
    @JsonProperty("typ_planu")
    private String planType;
    @JsonProperty("planu")
    private String plan;
    @JsonProperty("obowiazywanie")
    private String planTime;
    @JsonProperty("shape_area")
    private Double shapeArea;
    @JsonProperty("shape_len")
    private Double shapeLength;
    @JsonProperty("rank")
    private Double rank;
}
