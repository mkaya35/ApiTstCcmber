package com.lowes.ezship.cucumber.actions;

import com.lowes.ezship.config.AuthorizationService;
import com.lowes.ezship.util.EnvironmentSelector;
import com.lowes.ezship.config.WebServiceEndPoints;
import io.restassured.response.Response;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

@Slf4j
@Data
public class Actions {

    public Response response;

    @Steps
    AuthorizationService authorizationService;

    @Step("Call web service endpoint")
    public Response callEndpoint(String webServiceEndpoint) {
        return callEndpointHttp(webServiceEndpoint, "");
    }

    @Step("Call web service endpoint with body")
    public Response callEndpoint(String webServiceEndpoint, String body) {
        return callEndpointHttp(webServiceEndpoint, body);
    }


    private Response callEndpointHttp(String webServiceEndpoint, String body) {
        String url = EnvironmentSelector.getEzshipEnvUri() + WebServiceEndPoints.valueOf(webServiceEndpoint).getUrl();
        String method = WebServiceEndPoints.valueOf(webServiceEndpoint).getMethod();
        String auth = getServiceBasicAuth(url);
        log.info("URL Calling="+url+" -method="+method);
        return callEndpointHttpMethod(url, method,auth, body);

    }

    private Response callEndpointHttpMethod(String url, String method,String auth, String body) {
        switch (method) {
            case "GET":
                return callEndpointHttpMethodGet(url,auth);
            case "POST":
                return callEndpointHttpMethodPost(url, auth, body);
            default:
                throw new Error("Method" + method + "not supported");
        }
    }

    private Response callEndpointHttpMethodGet(String url, String auth) {
        this.response= SerenityRest.given()
                .relaxedHTTPSValidation()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .header("authorization", auth)
                .get(url);
        return response;

    }

    private Response callEndpointHttpMethodPost(String url, String auth,String body) {
         this.response = SerenityRest.given()
                .relaxedHTTPSValidation()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .header("authorization", auth)
                .body(body)
                .when()
                .post(url);
        return response;
    }

    private String getServiceBasicAuth(String url) {
        String auth="NO_AUTH";
        if (url.contains("smsezcvsrv")) {
            auth = authorizationService.getVendorSrvCreds();
        } else if (url.contains("smsezcgsrv")) {
            auth = authorizationService.getGeographySrvCreds();
        } else if (url.contains("smsezcrsrv")) {
            auth = authorizationService.getBaseRateSrvCreds();
        }
        return auth;
    }


}
