package com.test.rest.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/crear_user.feature",
        glue = "com.test.rest.stepdefinitions",
        snippets = SnippetType.CAMELCASE)
public class CrearUsuario {
}
