package org.Testing.Payloads;

import io.restassured.response.Response;
import org.Testing.TestSteps.HttpMethods;
import org.Testing.Utilities.PropertiesFileLoad;

import java.io.IOException;
import java.util.Properties;

public class BoardData {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
