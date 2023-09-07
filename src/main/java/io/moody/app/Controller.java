package io.moody.app;

import io.javalin.Javalin;

public class Controller {
    
    ProductService service = new ProductService();


    public void setEndpoints(Javalin app) {
        app.get("/products", ctx -> service.getAllProducts(ctx));
        app.get("/products/{id}", service::getProductById); //pathParam usage
    }
}
