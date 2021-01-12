package pl.puch.puchapp.forest.services.rest;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pl.puch.puchapp.forest.dto.ForestRequestDto;
import pl.puch.puchapp.forest.errors.JsonResponseParserException;

class ForestRestClientTest {

    ForestRestClient forestRestClient = new ForestRestClient();

    @Test
    public void sendRequestToForestApi0LimitTest() {
        ForestRequestDto forestRequestDto = new ForestRequestDto();
        forestRequestDto.setResourceId("75bedfd5-6c83-426b-9ae5-f03651857a48");
        forestRequestDto.setLimit("0");

        var result = forestRestClient.sendRequestToForestApi(forestRequestDto);

        Assert.assertEquals(result.getForestData().size(), Integer.parseInt(forestRequestDto.getLimit()));
        Assert.assertNotNull(result.getTotal());
        Assert.assertNotNull(result.getLinks());
    }

    @Test
    public void sendRequestToForestApi10LimitTest() {
        ForestRequestDto forestRequestDto = new ForestRequestDto();
        forestRequestDto.setResourceId("75bedfd5-6c83-426b-9ae5-f03651857a48");
        forestRequestDto.setLimit("10");

        var result = forestRestClient.sendRequestToForestApi(forestRequestDto);

        Assert.assertEquals(result.getForestData().size(), Integer.parseInt(forestRequestDto.getLimit()));
        Assert.assertNotNull(result.getTotal());
        Assert.assertNotNull(result.getLinks());
    }

    @Test
    public void sendRequestToForestApi50LimitTest() {
        ForestRequestDto forestRequestDto = new ForestRequestDto();
        forestRequestDto.setResourceId("75bedfd5-6c83-426b-9ae5-f03651857a48");
        forestRequestDto.setLimit("50");

        var result = forestRestClient.sendRequestToForestApi(forestRequestDto);

        Assert.assertEquals(result.getForestData().size(), Integer.parseInt(forestRequestDto.getLimit()));
        Assert.assertNotNull(result.getTotal());
        Assert.assertNotNull(result.getLinks());
    }

    @Test
    public void sendRequestToForestApiQueryTest() {
        ForestRequestDto forestRequestDto = new ForestRequestDto();
        forestRequestDto.setResourceId("75bedfd5-6c83-426b-9ae5-f03651857a48");
        forestRequestDto.setQuery("Bemowo");

        var result = forestRestClient.sendRequestToForestApi(forestRequestDto);

        Assert.assertFalse(result.getForestData().isEmpty());
        Assert.assertTrue(result.getForestData().stream().allMatch(forest -> forest.toString().contains("Bemowo")));
    }

    @Test
    public void sendRequestToForestApiJsonResponseParserExceptionTest() {
        ForestRequestDto forestRequestDto = new ForestRequestDto();
        forestRequestDto.setResourceId("75bedfd5-6c83-426b-9ae5-f03651857a");
        forestRequestDto.setLimit("50");

        JsonResponseParserException exception = Assert.assertThrows(
                JsonResponseParserException.class,
                () -> forestRestClient.sendRequestToForestApi(forestRequestDto));

        Assert.assertEquals("Error during JSON response processing. Error message: \"Nieautoryzowany dostęp do danych\"", exception.getMessage());
    }
}
