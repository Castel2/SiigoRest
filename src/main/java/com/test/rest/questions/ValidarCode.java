package com.test.rest.questions;

import com.test.rest.utils.Constantes;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidarCode implements Question<Boolean> {

    private String code;

    public ValidarCode(String code) {
        this.code = code;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        Response userResponse = actor.recall(Constantes.RESPONSE);
        boolean validateCode = false;
        if(String.valueOf(userResponse.getStatusCode()).equals(code)){
            validateCode = true;
        }
        return validateCode;
    }

    public static ValidarCode validarCode(String code){
        return new ValidarCode(code);
    }

}
