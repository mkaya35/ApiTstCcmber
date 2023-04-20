package com.lowes.ezship;


import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        glue = {"com.lowes.ezship"},
        plugin = {"pretty"},
        features = "classpath:features",
        tags = {"@automated"}
)
public class VendorServTestRunner {}
