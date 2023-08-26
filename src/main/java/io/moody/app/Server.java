package io.moody.app;
import io.javalin.Javalin;

public class Server {
    private static Javalin app;
    public static void start() {
        app = Javalin.create();
        app.start(7000);
    }

    public static void stop() {
        app.stop();
    }    
}
