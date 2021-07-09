package org.example.data;

public class ProductFactory {

    private static final String DESCRIPTION = null;

    public static Product getDescriptionValue() {
        Product product = new Product(DESCRIPTION);
        return product;
    }

}
