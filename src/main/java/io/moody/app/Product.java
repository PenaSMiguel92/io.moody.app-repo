package io.moody.app;

/*
 * POJO Design Pattern
 *          -'Plain Old Java Object'
 *          -Design pattern to create a very simple and standard java object
 *          -private fields
 *          -getters and settters for all fields
 *          -no argument and fully parameterized constructor
 *          -override the object class methods (toString, hashCode, equals)
 *          -implement Serializable
 */

public class Product {
    private long productId;
    private String productName;
    private double productPrice;

    public Product() {
        super();
    }
    
    public Product(long productId, String productName, double productPrice) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public long getProductId() {
        return this.productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return this.productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getProductPrice() {
        return this.productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (this.productId ^ (this.productId >>> 32));
        result = prime * result + ((this.productName == null) ? 0 : this.productName.hashCode());
        long temp;
        temp = Double.doubleToLongBits(this.productPrice);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (this.productId != other.productId)
            return false;
        if (this.productName == null) {
            if (other.productName != null)
                return false;
        } else if (!this.productName.equals(other.productName))
            return false;
        if (Double.doubleToLongBits(this.productPrice) != Double.doubleToLongBits(other.productPrice))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Product [productId = " + this.productId
                + ", productName = " + this.productName
                + ", productPrice = " + this.productPrice + "]";
    }

}
