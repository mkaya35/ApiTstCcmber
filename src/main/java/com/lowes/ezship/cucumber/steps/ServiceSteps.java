package com.lowes.ezship.cucumber.steps;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ServiceSteps extends BaseSteps{

    //Method that calls a web service endpoint configured in the enum class WebServiceEndpoints. The string used needs to be defines in the enum class
    @Given("the client calls {string} endpoint")
    public void theUserCallsEndpoint(String webServiceEndpoint) {
        this.response = actions.callEndpoint(webServiceEndpoint);
    }

    //Method that does the same thing as ""the client calls {string} endpoint" step but store the response in another Response object in order to do a comparison check between to JSON objects. This can be used for a baseline-under test checking approach where you first call the baseline endpoint, then under test endpoint and compare the two responses
    @When("the client calls {string} endpoint again")
    public void theUserCallsEndpointAgain(String webServiceEndpoint) {
        this.responseNext = actions.callEndpoint(webServiceEndpoint);
    }

    //Same as "the client calls {string} endpoint" method but also checks that HTTP response code is 200
    @When("the client calls {string} endpoint with success")
    public void theUserCallsEndpointWithSuccess(String webServiceEndpoint) {
        theUserCallsEndpoint(webServiceEndpoint);
        theClientShouldReceiveHttpResponseCode(200);
    }

    // Same as "the client calls {string} endpoint again" method but also checks that HTTP response code is 200
    @When("the client calls {string} endpoint again with success")
    public void theUserCallsEndpointAgainWithSuccess(String webServiceEndpoint) {
        theUserCallsEndpointAgain(webServiceEndpoint);
        theClientShouldReceiveHttpResponseCode(200);
    }

    // Method used for doing a REST call for a method that requires a body
    @When("the client calls {string} endpoint with body {string}")
    public void theUserCallsEndpoint(String webServiceEndpoint, String body) {
        this.response = actions.callEndpoint(webServiceEndpoint, body);
    }

    //Method that check the response object that has status code XXX (type int)
    @Then("the client should receive an HTTP {int} response code")
    public void theClientShouldReceiveHttpResponseCode(int httpCode) {
        assertThat(actions.getResponse().getStatusCode(), equalTo(httpCode));
    }


    @Then("the client should see response containing {string} message")
    public void the_client_should_see_response_containing_message(String expected) {
        String result = response.asString().toUpperCase();
        assertThat(result, containsString(expected));
    }

}
