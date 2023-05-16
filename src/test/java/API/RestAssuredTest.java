package API;

import it_academy.Rest_api.model.SushiProduct;
import it_academy.Rest_api.service.SushiService;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RestAssuredTest {
    SushiService sushiService = new SushiService();

    @Test
    public void productElementsTest() {
        sushiService
                .getSushiProducts()
                .forEach(RestAssuredTest::assertProductFieldsExist);
    }

    @Test
    public void productFilterTest() {
        sushiService
                .getSushiNamePrefixesWithFilter()
                .forEach(product -> assertThat(product.getName_prefix()).isEqualTo("Роллы"));
    }

    private static void assertProductFieldsExist(SushiProduct product) {
        assertThat(product.getName()).isNotNull();
        assertThat(product.getId()).isNotNull();
        assertThat(product.getKey()).isNotNull();
        assertThat(product.getFull_name()).isNotNull();
    }
}
