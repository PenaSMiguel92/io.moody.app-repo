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
}
