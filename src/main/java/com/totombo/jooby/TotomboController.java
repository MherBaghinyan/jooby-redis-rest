package com.totombo.jooby;

import org.jooby.mvc.GET;
import org.jooby.mvc.POST;
import org.jooby.mvc.Path;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Gebruiker on 1/17/2018.
 */
@Path("/api")
public class TotomboController {

/*
http://www.baeldung.com/jooby
https://github.com/eugenp/tutorials/blob/master/jooby/src/test/java/com/baeldung/jooby/AppTest.java


http://jooby.org/guides/hello-restful/
https://github.com/jooby-project/greeting/blob/master/src/main/java/greeting/Greetings.java
 */

    @Path({"/count"})
    @GET
    public String incrementCounter() {

        AtomicInteger count = new AtomicInteger(0);
        return "count: " + count.incrementAndGet();
    }
}
