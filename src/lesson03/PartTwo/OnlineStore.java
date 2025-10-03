package lesson03.PartTwo;

import java.util.HashMap;
import java.util.Map;

import lombok.AllArgsConstructor;

public class OnlineStore {

    private Map<Integer, Product> products = new HashMap<>();

    public void addProduct(Product product) {
        if (product != null) {
            products.put(product.code, product);
        }
    }

    public void buyProduct(int code, int count) {
        Product product = products.get(code);
        if (product.count >= count) {
            product.count = product.count - count;
        }
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    @AllArgsConstructor
    public class Product {
        private final int code;
        private final String name;
        private final double price;
        private int count;

        public String getProductInfo() {
            return "Code - " + code + ", name - " + name + ", price - " + price + ", count - " + count;
        }
    }
}
