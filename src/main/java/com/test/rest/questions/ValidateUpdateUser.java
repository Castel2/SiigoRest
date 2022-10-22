package com.test.rest.questions;

import com.test.rest.models.user.ResponseUserUpdate;
import com.test.rest.utils.Constantes;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateUpdateUser implements Question<Boolean> {

    private String code;
    private String name;
    private String job;
    private String updatedAt;

    public ValidateUpdateUser(String code, String name, String job, String updatedAt) {
        this.code = code;
        this.name = name;
        this.job = job;
        this.updatedAt = updatedAt;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean validateJob = false;
        boolean validateName = false;
        boolean validateCreatedAt = false;
        Response response = actor.recall(Constantes.RESPONSE);
        ResponseUserUpdate userUpdate = response.getBody().as(ResponseUserUpdate.class, ObjectMapperType.GSON);
        if(ValidarCode.validarCode(code).answeredBy(actor)){
            validateName =  userUpdate.getName().equals(name);
            validateJob = userUpdate.getJob().equals(job);
            validateCreatedAt = userUpdate.getUpdatedAt().contains(updatedAt);
        }
        return validateName && validateJob && validateCreatedAt;
    }

    public static ValidateUpdateUser updateUser(String code, String name, String job, String createdAt){
        return new ValidateUpdateUser(code,name,job,createdAt);
    }

}
