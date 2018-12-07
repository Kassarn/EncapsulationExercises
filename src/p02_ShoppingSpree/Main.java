package p02_ShoppingSpree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] peopleLine =  reader.readLine().split(";");
        String []productLine =  reader.readLine().split(";");
        Person person =null;
        Product product =null;
        List<Person> persons  =  new ArrayList<>();
        List<Product> products  =  new ArrayList<>();
            try {
                for (int i = 0; i < peopleLine.length; i++) {
                    String[] peopleTokens = peopleLine[i].split("=");
                    String peopleName = peopleTokens[0];
                    double peopleMoney = Double.parseDouble(peopleTokens[1]);
                    person = new Person(peopleName, peopleMoney);
                    persons.add(person);
                }
                for (int i = 0; i < productLine.length; i++) {
                    String[] productTokens = productLine[i].split("=");
                    String productName = productTokens[0];
                    double peopleCost = Double.parseDouble(productTokens[1]);
                    product = new Product(productName, peopleCost);
                    products.add(product);
                }

                String line = "";
                while (!"END".equals(line = reader.readLine())) {
                    String[] command = line.split(" ");
                    String personName = command[0];
                    String productName = command[1];
                    for (Person person1 : persons) {
                        if (personName.equals(person1.getName())) {
                            for (Product product1 : products) {
                                if (productName.equals(product1.getName())) {
                                    person1.buyProduct(product1);
                                }
                            }
                        }
                    }

                }
                for (Person person1 : persons) {
                    if (!person1.getProducts().isEmpty()) {
                        System.out.println(person1.toString());
                    } else {
                        System.out.printf("%s - Nothing bought\n", person1.getName());
                    }
                }

            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
    }
}
