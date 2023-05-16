package it_academy.Rest_api.service;

import com.google.common.collect.ImmutableMap;
import it_academy.Rest_api.endpoints.OnlinerEndpoints;
import it_academy.Rest_api.model.SushiProduct;

import java.util.List;
import java.util.Map;

import static it_academy.Rest_api.Utils.GetRequestUtils.makeGetRequestAndRecievBody;

public class SushiService {
    public List<SushiProduct> getSushiProducts() {
        return makeGetRequestAndRecievBody(OnlinerEndpoints.getCatalogProductEndPoint(),
                configureHeaders(), null)
                .jsonPath()
                .getList("products", SushiProduct.class);
    }

    public List<SushiProduct> getSushiNamePrefixesWithFilter() {
        return makeGetRequestAndRecievBody(OnlinerEndpoints.getCatalogProductEndPoint(),
                configureHeaders(), configureParams())
                .jsonPath()
                .getList("products", SushiProduct.class);
    }

    private Map<String, Object> configureHeaders() {
        return ImmutableMap.of("Host", "catalog.onliner.by");
    }

    private Map<String, Object> configureParams() {
        return ImmutableMap.of(
                "sushi_typ[0]", "roll",
                "sushi_typ[operation]", "union"
        );
    }
}
