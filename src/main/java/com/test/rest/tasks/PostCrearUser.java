package com.test.rest.tasks;

import com.test.rest.models.user.UserCreate;
import com.test.rest.utils.Constantes;
import io.restassured.mapper.ObjectMapperType;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class PostCrearUser implements Task {

    private String path;
    private UserCreate body;

    public PostCrearUser(String path, UserCreate body) {
        this.path = path;
        this.body = body;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Post.to(path).with(request -> request.header("Content-Type", "application/json")
                .body(body, ObjectMapperType.GSON)));
        actor.remember(Constantes.RESPONSE, SerenityRest.lastResponse());
    }

    public static PostCrearUser crearUser(String path, UserCreate body) {
        return Tasks.instrumented(PostCrearUser.class, path, body);
    }
}
