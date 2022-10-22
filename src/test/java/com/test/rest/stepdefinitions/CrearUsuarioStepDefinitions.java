package com.test.rest.stepdefinitions;

import com.test.rest.excepcion.CrearError;
import com.test.rest.models.user.UserCreate;
import com.test.rest.questions.ValidateCreateUser;
import com.test.rest.tasks.PostCrearUser;
import com.test.rest.utils.Constantes;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;

import java.util.List;

public class CrearUsuarioStepDefinitions {

    @Before
    public void setUp() {
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at(Constantes.URL_BASE)));
        OnStage.theActorCalled("Channel");
    }

    @When("^se envia la informacion del usuario$")
    public void seEnviaLaInformacionDelUsuario(List<UserCreate> crearUsuario) {
        OnStage.theActorInTheSpotlight().attemptsTo(PostCrearUser.crearUser(Constantes.USER, crearUsuario.get(0)));
    }


    @Then("^se espera la respuesta (.*) y los mismos datos enviados con la fecha de creacion (.*), (.*), (.*)$")
    public void seEsperaLaRespuestaCodeYLosMismosDatosEnviadosConLaFechaDeCreacion(String code, String name, String job, String createdAt) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateCreateUser.createdUser(code, name, job, createdAt)).orComplainWith(CrearError.class, CrearError.message));
    }


}
