package io.moody.app;
import io.javalin.Javalin;

public class Server {

    public static Javalin getInstance() {
        Javalin app = Javalin.create();

        //reading
        app.get("/testing", ctx -> {
            ctx.result("Hello World");
        });

        //modification
        app.post("/testing2", ctx -> {
            ctx.result("Hello Not World.");
        });

        return app;
    } 
}
