package com.totombo.jooby;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Gebruiker on 1/18/2018.
 */
public class Response {

    private String value;

    public Response(String count) {
        this.value = count;
    }

    public String getValue() {
        return value;
    }
}
