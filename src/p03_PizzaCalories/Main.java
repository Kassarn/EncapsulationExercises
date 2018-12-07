package p03_PizzaCalories;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static final double CALORIES_PER_GRAM = 2.0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
           String line ="";
           while (!"END".equals(line =reader.readLine())) {
               String[] pizzaTokens = line.split("\\s+");
               if(pizzaTokens.length<3){
                   throw  new  IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
               }
               String pizzaName = pizzaTokens[1];
               int toppings = Integer.parseInt(pizzaTokens[2]);
               Pizza pizza =  new Pizza(pizzaName,toppings);
               String[] doughTokens = reader.readLine().split(" ");
               String flourType = doughTokens[1];
               double weight = Double.parseDouble(doughTokens[3]);
               String bakingTechnique = doughTokens[2];
               Dough dough = new Dough(flourType, weight, bakingTechnique);
               pizza.SetDough(dough);


               for (int i = 0; i <toppings ; i++) {
                   String[] toppingTokens = reader.readLine().split(" ");

                   String toppingType = toppingTokens[1];
                   Double toppingWeight = Double.parseDouble(toppingTokens[2]);
                   Topping topping = new Topping(toppingType, toppingWeight);
                   pizza.addToping(topping);

               }

               System.out.println(pizza.toString());
           }
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
