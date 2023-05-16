package it_academy.Rest_api.Utils;

import io.restassured.response.ResponseBody;
import org.apache.commons.collections4.MapUtils;
import org.apache.http.HttpStatus;

import java.util.ArrayList;
import java.util.Map;

import static io.restassured.RestAssured.given;

public final class GetRequestUtils {
    private GetRequestUtils(){}

    public static ResponseBody makeGetRequestAndRecievBody (String endPoint, Map<String, Object> headers,
                                                            Map<String, Object> params) {
        return given()
                .headers(MapUtils.emptyIfNull(headers))
                .params(MapUtils.emptyIfNull(params))
                .when()
                .get(endPoint)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract()
                .response()
                .getBody();
    }
}
