package com.lowes.ezship.cucumber.actions;

import com.lowes.ezship.config.AuthorizationService;
import com.lowes.ezship.config.WebServiceEndPoints;
import com.lowes.ezship.model.common.ShipmentItemDetails;
import com.lowes.ezship.model.common.ShipmentRespItemDetails;
import com.lowes.ezship.model.vendor.VendorServiceRequest;
import com.lowes.ezship.util.EnvironmentSelector;
import com.lowes.ezship.util.data.loader.VendorRequestLoader;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;

import java.util.Collection;
import java.util.List;

public class VendorActions extends Actions {
    private static final String VENDOR_SERVICE_REQUEST_FILE = "VendorRequest.json";

    @Steps
    AuthorizationService authorizationService;

    public VendorServiceRequest vendorServiceRequestBuildWithParams(String fulfillmentMethod, String vendorId, String shopKey, String serviceLevel, Integer itemQty, String itemId){
        VendorServiceRequest vsr= VendorRequestLoader.loadVendorServiceRequestFromJson(VENDOR_SERVICE_REQUEST_FILE);
        vsr.setFulfillmentMethod(fulfillmentMethod);
        vsr.setVendorId(vendorId);
        vsr.setShopKey(shopKey);
        vsr.setServiceLevel(serviceLevel);
        for(ShipmentItemDetails shipmentItemDetails: vsr.getShipmentDetails().getShipmentItemDetails()){
            shipmentItemDetails.setItemId(itemId);
            shipmentItemDetails.setItemQty(itemQty);
        }
        return vsr;
    }




}
