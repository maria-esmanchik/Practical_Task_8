package org.example.data;

public class Product {

    private String productTitle;
    private String productDescription;
    private String productPrice;
    private String productQuantity;

    public Product(String productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductTitle() { return productTitle; }

    public void setProductTitle(String productTitle) { this.productTitle = productTitle; }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(String productQuantity) {
        this.productQuantity = productQuantity;
    }
}
