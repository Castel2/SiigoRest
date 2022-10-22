package com.test.rest.questions;

import com.test.rest.models.user.ResponseUserCreate;
import com.test.rest.utils.Constantes;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ValidateCreateUser implements Question<Boolean> {

    private String code;
    private String name;
    private String job;
    private String createdAt;

    public ValidateCreateUser(String code, String name, String job, String createdAt) {
        this.code = code;
        this.name = name;
        this.job = job;
        this.createdAt = createdAt;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        boolean validateJob = false;
        boolean validateName = false;
        boolean validateCreatedAt = false;
        Response response = actor.recall(Constantes.RESPONSE);
        ResponseUserCreate userCreate = response.getBody().as(ResponseUserCreate.class, ObjectMapperType.GSON);
        if(ValidarCode.validarCode(code).answeredBy(actor)){
            validateName =  userCreate.getName().equals(name);
            validateJob = userCreate.getJob().equals(job);
            validateCreatedAt = userCreate.getCreatedAt().contains(createdAt);
        }
        return validateName && validateJob && validateCreatedAt;
    }

    public static ValidateCreateUser createdUser(String code, String name, String job, String createdAt){
        return new ValidateCreateUser(code,name,job,createdAt);
    }
}
