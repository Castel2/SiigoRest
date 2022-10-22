package com.test.rest.tasks;

import com.test.rest.utils.Constantes;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetUser implements Task {

    private String path;

    public GetUser(String path) {
        this.path = path;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(path));
        actor.remember(Constantes.RESPONSE, SerenityRest.lastResponse());
    }

    public static GetUser to(String path){
        return Tasks.instrumented(GetUser.class, path);
    }
}
