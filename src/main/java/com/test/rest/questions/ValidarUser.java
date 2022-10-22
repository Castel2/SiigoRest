package com.test.rest.questions;

import com.test.rest.models.user.UserResponse;
import com.test.rest.utils.Constantes;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidarUser implements Question<Boolean> {

    private String code;
    private String email;
    private String first_name;
    private String last_name;

    public ValidarUser(String code, String email, String first_name, String last_name) {
        this.code = code;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean validarEmail = false;
        boolean validarFirst_name = false;
        boolean validarLast_name = false;
        Response response = actor.recall(Constantes.RESPONSE);
        UserResponse userResponse = response.getBody().as(UserResponse.class, ObjectMapperType.GSON);
        if (ValidarCode.validarCode(code).answeredBy(actor)) {
            validarEmail = userResponse.getData().getEmail().equals(email);
            validarFirst_name = userResponse.getData().getFirst_name().equals(first_name);
            validarLast_name = userResponse.getData().getLast_name().equals(last_name);
        }
        return validarEmail && validarFirst_name && validarLast_name;
    }

    public static ValidarUser validarUsuario(String code,String email, String first_name, String last_name){
        return new ValidarUser(code,email,first_name,last_name);
    }
}
