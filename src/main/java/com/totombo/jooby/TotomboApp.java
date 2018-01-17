package com.totombo.jooby;

import org.jooby.Jooby;
import org.jooby.Session;
import org.jooby.jedis.Redis;
import org.jooby.jedis.RedisSessionStore;
import org.jooby.json.Jackson;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Gebruiker on 1/17/2018.
 */
public class TotomboApp extends Jooby {

    {
        port(9999);
        securePort(4545);

        use(new Jackson());
    }

    {
        get("api/", () -> "Totombo API");
    }

    {
        AtomicInteger count = new AtomicInteger(0);
        get("/api/count/get", req -> "count : " + 0);
    }

    {
		cookieSession();
//
//		use(new Redis());
//
//		session(RedisSessionStore.class);
//
//        get("/api/count", req -> {
//            Session session = req.session();
//            session.set("counter", 0);
//            return session.get("counter").value();
//        });
//
//        post("/api/count/drop", req -> {
//            Session session = req.session();
//            session.set("counter", 0);
//            return session.get("counter").value();
//        });
    }

    public static void main(final String[] args) {

        run(TotomboApp::new, args);
    }
}
