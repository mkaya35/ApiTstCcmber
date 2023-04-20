package com.lowes.ezship.cucumber.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lowes.ezship.cucumber.actions.Actions;
import com.lowes.ezship.cucumber.actions.VendorActions;
import com.lowes.ezship.model.vendor.VendorServiceRequest;
import com.lowes.ezship.model.vendor.VendorServiceResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import net.thucydides.core.annotations.Shared;
import net.thucydides.core.annotations.Steps;
import org.skyscreamer.jsonassert.Customization;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.comparator.CustomComparator;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.*;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BaseSteps {


    protected static ObjectMapper mapper = new ObjectMapper();
    protected VendorServiceRequest vendorServiceRequest;
    protected VendorServiceResponse vendorServiceResponse;
    protected Response response;
    protected Response responseNext;
    protected BaseSteps baseSteps;

    @Shared
    Actions actions;

    @Shared
    VendorActions vendorActions;



}
