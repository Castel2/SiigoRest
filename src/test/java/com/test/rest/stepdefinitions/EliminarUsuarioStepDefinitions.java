package com.test.rest.stepdefinitions;

import com.test.rest.questions.ValidarCode;
import com.test.rest.tasks.DeleteUser;
import com.test.rest.utils.Constantes;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;

public class EliminarUsuarioStepDefinitions {

    @Before
    public void setUp() {
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at(Constantes.URL_BASE)));
        OnStage.theActorCalled("Channel");
    }

    @When("^se envia el id (.*) de un usuario para eliminar$")
    public void seEnviaElIdDeUnUsuarioParaEliminar(String id) {
        OnStage.theActorInTheSpotlight().attemptsTo(DeleteUser.eliminaUser(Constantes.USER + id));
    }


    @Then("^se espera el codigo de resputes (.*)$")
    public void seEsperaElCodigoDeResputes(String code) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidarCode.validarCode(code)));
    }

}
