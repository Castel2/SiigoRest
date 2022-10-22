package com.test.rest.stepdefinitions;

import com.test.rest.excepcion.CrearError;
import com.test.rest.models.user.UserCreate;
import com.test.rest.questions.ValidateUpdateUser;
import com.test.rest.tasks.PutActualizarCliente;
import com.test.rest.utils.Constantes;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abiities.CallAnApi;

import java.util.List;

public class ActualizarUsuarioStepDefinitions {

    @Before
    public void setUp(){
        OnStage.setTheStage(Cast.whereEveryoneCan(CallAnApi.at(Constantes.URL_BASE)));
        OnStage.theActorCalled("Channel");
    }

    @When("^se envia la informacion del usuario (.*) para actualizar$")
    public void seEnviaLaInformacionDelUsuarioParaActualizar(String id, List<UserCreate> userCreate) {
        OnStage.theActorInTheSpotlight().attemptsTo(PutActualizarCliente.actualizarCliente(Constantes.USER+id,userCreate.get(0)));
    }

    @Then("^se espera la respuesta (.*) y los mismos datos enviados con la fecha de actualizacion (.*), (.*), (.*)$")
    public void seEsperaLaRespuestaCodeYLosMismosDatosEnviadosConLaFechaDeCreacion(String code, String name, String job, String updatedAt) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidateUpdateUser.updateUser(code, name, job, updatedAt)).orComplainWith(CrearError.class, CrearError.message));
    }

}
