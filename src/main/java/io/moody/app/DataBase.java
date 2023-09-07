package io.moody.app;

/*
 * will act as a stand in for DAO & DB layer
 */
import java.util.*;

public class DataBase {
    private List<Product> myProducts;
    private int idGenerator = 0;

    public DataBase() {
        super();
        myProducts = new ArrayList<Product>();
    }

    public void setupDatabase() {
        Collections.addAll(this.myProducts,
                new Product(++idGenerator, "Sweatshirt", 19.99),
                new Product(++idGenerator, "Cargo Pants", 29.99),
                new Product(++idGenerator, "Blue Jeans", 33.99),
                new Product(++idGenerator, "Hoodie", 39.99),
                new Product(++idGenerator, "12pk Socks", 9.99),
                new Product(++idGenerator, "Beanie", 17.99));
    }
    
    //DAO method stand-ins
    public List<Product> getMyProducts() {
        return this.myProducts;
    }

    public Product getProductById(long id) {
        for (Product p : this.myProducts)
            if (p.getProductId() == id)
                return p;
        return null;
    }

    public Product addProduct(Product product) {
        product.setProductId(++idGenerator);
        this.myProducts.add(product);

        return product;
    }

    public Product updateProduct(Product product) {
        boolean itemFound = false;
        for (Product p : this.myProducts)
            if (p.getProductId() == product.getProductId()) {
                itemFound = true;
                p.setProductName(product.getProductName());
                p.setProductPrice(product.getProductPrice());
            }

        return itemFound ? product : null;
    }

    public Product deleteProduct(long id) {
        Product p = null;
        for (int i = 0; i < this.myProducts.size(); i++)
            if (this.myProducts.get(i).getProductId() == id) {
                p = this.myProducts.get(i);
                this.myProducts.remove(i);
            }

        return p;
    }
}
