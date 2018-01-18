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

    @Path({"/test"})
    @GET
    public String api() {

        return "Totombo API";
    }
}
