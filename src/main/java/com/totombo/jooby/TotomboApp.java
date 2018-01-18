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

//        use(TotomboController.class);
    }

    {
        get("api/", () -> "Totombo API");
    }

    {
        use(new Jackson());

		use(new Redis());

		session(RedisSessionStore.class);

        get("/api/count", req -> {

            Session session = req.session();

            Integer sessionValue = session.get("counter").toOptional()
                    .map(s -> {
                        int count = Integer.parseInt(s);
                        return new AtomicInteger(count).incrementAndGet();
                            }
                    ).orElse(new AtomicInteger(0).incrementAndGet());

            session.set("counter", sessionValue);
            return new Response(session.get("counter").value());
        });

        get("/api/count/drop", req -> {
        Session session = req.session();

        Integer sessionValue = session.get("counter").toOptional()
                .map(s -> {
                            int count = Integer.parseInt(s);
                            return new AtomicInteger(count).decrementAndGet();
                        }
                ).orElse(new AtomicInteger(0).decrementAndGet());

        session.set("counter", sessionValue);
        return new Response(session.get("counter").value());
        });
    }

    public static void main(final String[] args) {

        run(TotomboApp::new, args);
    }
}
