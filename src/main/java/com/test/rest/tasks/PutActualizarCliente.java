package com.test.rest.tasks;

import com.test.rest.models.user.ResponseUserUpdate;
import com.test.rest.models.user.UserCreate;
import com.test.rest.utils.Constantes;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class PutActualizarCliente implements Task {

    private String path;
    private UserCreate body;

    public PutActualizarCliente(String path, UserCreate body) {
        this.path = path;
        this.body = body;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Put.to(path).with(request -> request.header("Content-Type", "application/json")
                .body(body, ObjectMapperType.GSON)));
        actor.remember(Constantes.RESPONSE, SerenityRest.lastResponse());

    }

    public static PutActualizarCliente actualizarCliente(String path, UserCreate body){
        return Tasks.instrumented(PutActualizarCliente.class,path,body);
    }
}
