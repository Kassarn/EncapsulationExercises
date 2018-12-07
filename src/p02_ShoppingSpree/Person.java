package p02_ShoppingSpree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    Person(String name, double money) {
        setName(name);
        setMoney(money);
        products = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.isEmpty() || name.matches("\\s+"))  {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    void buyProduct(Product product) {
        if (this.getMoney() - product.getCost() >= 0) {
            this.products.add(product);
            this.setMoney(this.getMoney() - product.getCost());
            System.out.printf("%s bought %s\n", this.name, product.getName());
        } else {
            System.out.printf("%s can't afford %s\n", this.name, product.getName());
        }
    }

    String getName() {
        return name;
    }

    private double getMoney() {
        return money;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return  String.format("%s - %s", this.getName() , Arrays.toString(this.products.toArray())
                .replace("[","")
                .replace("]",""));
    }
}
