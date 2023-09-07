package io.moody.app;

import io.javalin.http.Context;
import java.util.*;

public class ProductService {
    DataBase db = new DataBase();

    public ProductService() {
        db.setupDatabase();
    }
    
    public void getAllProducts(Context ctx) {
        List<Product> products = this.db.getMyProducts();
        ctx.json(products);

        ctx.status(200);
    }

    public void getProductById(Context ctx) {
        String paramValue = ctx.pathParam("id");
        int id = Integer.parseInt(paramValue);
        Product p = db.getProductById(id);

        if (p != null)
            ctx.json(p);
        else
            ctx.status(400).result("Product not found");
    }
}
