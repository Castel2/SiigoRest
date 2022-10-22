package com.test.rest.stepdefinitions;

import com.test.rest.questions.ValidarCode;
import com.test.rest.questions.ValidarUser;
import com.test.rest.tasks.GetUser;
import com.test.rest.utils.Constantes;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;

public class BuscarUsuarioStepDefinitions {


    @Before
    public void setUp(){
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at(Constantes.URL_BASE)));
        OnStage.theActorCalled("Channel");
    }

    @When("^se consume el servicio get con el id (.*)$")
    public void seConsumeElServicioGetConElId(String id) {
        OnStage.theActorInTheSpotlight().attemptsTo(GetUser.to(Constantes.USER+id));
    }


    @Then("^se espera la respuesta (.*) y los siguientes datos del usuario (.*) (.*) (.*)$")
    public void seEsperaLosSiguientesDatosDelUsuarioEmmaWongReqresInEmmaWong(String code, String email, String first_name, String last_name) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidarUser.validarUsuario(code,email,first_name,last_name)));
    }

    @Then("^se espera una respuesta erronea con codigo (.*)$")
    public void seEsperaRespuestaErronea(String code) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidarCode.validarCode(code)));
    }

}
