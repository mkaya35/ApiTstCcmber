package com.lowes.ezship.cucumber.steps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.lowes.ezship.model.vendor.VendorServiceResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import static org.junit.Assert.assertTrue;



public class VendorSteps extends BaseSteps {

    @Given("the client uses the following vendor body details: fulfillmentMethod of {string}, vendorId of {string}, shopKey of {string},serviceLevel of {string},itemQty of {int},itemId of {string}")
    public void vendor_Service_Request_Build(String fulfillmentMethod, String vendorId, String shopKey, String serviceLevel, Integer itemQty, String itemId) {
        this.vendorServiceRequest= vendorActions.vendorServiceRequestBuildWithParams(fulfillmentMethod,vendorId,shopKey,serviceLevel,itemQty,itemId);
    }
    @When("the client calls vendor service {string} endpoint")
    public void the_client_calls_vendor_service_endpoint(String endpoint) throws JsonProcessingException {
        Response resp=actions.callEndpoint(endpoint,  mapper.writeValueAsString(vendorServiceRequest));
        vendorServiceResponse=  mapper.readValue(resp.asString(),VendorServiceResponse.class);
        System.out.println("VCREQ= "+mapper.writeValueAsString(vendorServiceRequest));
    }
    @And("the client should see carrierCode of {string},carrierService of {string},calcShiptWeight of {double} in response")
    public void the_client_should_see_carrier_details(String carrierCode, String carrierService, Double calcShiptWeight) {
        Boolean result=vendorServiceResponse.getCarrierCodeServices().stream()
                .filter(p->carrierCode.equals(p.getCarrierCode()))
                .filter(p->carrierService.equals(p.getCarrierService()))
                .filter(p->calcShiptWeight==p.getCalculatedShipmentWeight()).findFirst().isPresent();
        assertTrue(result);
    }


}
