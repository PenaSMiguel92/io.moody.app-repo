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

    public void addNewProduct(Context ctx) {
        Product product = ctx.bodyAsClass(Product.class);
        if (product.getProductName() == null || product.getProductName().length() < 1) {
            ctx.status(400).result("Product was not added");
            return;
        }

        if (db.addProduct(product) != null)
            ctx.json(product);
        else
            ctx.status(400).result("Product was not added");
    }

    public void updateProductById(Context ctx) {
        Product product = ctx.bodyAsClass(Product.class);
        product.setProductId(Integer.valueOf(ctx.pathParam("id")));
        Product p = db.updateProduct(product);
        if (p != null)
            ctx.json(p);
        else
            ctx.status(400).result("Product could not be updated - product not found");
    }
    
    public void deleteProductById(Context ctx) {
        int id = Integer.valueOf(ctx.pathParam("id"));
        Product p = db.deleteProduct(id);
        if (p != null)
            ctx.json(p);
        else
            ctx.status(400).result("Product could not be deleted - product not found");
    }
}
