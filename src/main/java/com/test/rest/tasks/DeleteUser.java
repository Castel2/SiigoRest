package com.test.rest.tasks;


import com.test.rest.utils.Constantes;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class DeleteUser implements Task {

    private String path;

    public DeleteUser(String path) {
        this.path = path;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delete.from(path));
        actor.remember(Constantes.RESPONSE, SerenityRest.lastResponse());
    }

    public static DeleteUser eliminaUser(String path){
        return Tasks.instrumented(DeleteUser.class, path);
    }

}
