package com.totombo.jooby;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

import org.jooby.test.JoobyRule;
import org.junit.ClassRule;
import org.junit.Test;


/**
 * Created by Gebruiker on 1/17/2018.
 */
public class TotomboAppTest {

    @ClassRule
    public static JoobyRule app = new JoobyRule(new TotomboApp());

    @Test
    public void getTotomboApi() {

        get("/api").then().assertThat().body(equalTo("Totombo API"))
                .statusCode(200).contentType("text/html;charset=UTF-8");
    }
}
