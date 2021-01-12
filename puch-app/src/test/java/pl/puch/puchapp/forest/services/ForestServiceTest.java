package pl.puch.puchapp.forest.services;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pl.puch.puchapp.forest.dto.ForestResponseDto;
import pl.puch.puchapp.forest.errors.JsonResponseParserException;

class ForestServiceTest {

    ForestService forestService = new ForestService();

    @Test
    public void getForestResponseDtoTest() {
        String resourceId = "75bedfd5-6c83-426b-9ae5-f03651857a48";
        String limit = "50";
        String query = "";
        String offset = "";

        var result = forestService.getForestResponseDto(resourceId, limit, query, offset);

        Assert.assertNotNull(result);
        Assert.assertEquals(result.getClass(), ForestResponseDto.class);
    }

    @Test
    public void getForestResponseDtoThrowJsonResponseParserExceptionTest() {
        String resourceId = "";
        String limit = "50";
        String query = "";
        String offset = "";

        JsonResponseParserException exception = Assert.assertThrows(
                JsonResponseParserException.class,
                () -> forestService.getForestResponseDto(resourceId, limit, query, offset));

        Assert.assertEquals("Error during JSON response processing. Error message: \"Nieautoryzowany dostęp do danych\"", exception.getMessage());
    }
}
