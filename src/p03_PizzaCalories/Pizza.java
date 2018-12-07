package p03_PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
   private String name;
   private int numberOfToppings ;
   private Dough dough;
   private List<Topping> allTopings;
   private  double getTotalCalories;



    public Pizza(String name, int numberOfToppings) {
         setName(name);
        setNumberOfToppings(numberOfToppings);
        this.allTopings = new ArrayList<>(numberOfToppings);
    }

    private void setName(String name) {
        if(name.length()>15){
            throw  new  IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    private void setNumberOfToppings(int toppings) {
        if(toppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
        this.numberOfToppings = toppings;
    }
    private void setDough(Dough dough) {
        this.dough = dough;
    }
    public void  SetDough(Dough dough) {
    this.dough =dough;
    }

    public String getName() {
        return name;
    }

        public int getNumberOfToppings() {
        return numberOfToppings;
    }
    public void addToping(Topping topping) {
        this.allTopings.add(topping);
    }

    public double totalCalories () {
        double total =this.dough.calculateCalories();
        for (Topping topping : this.allTopings) {
          total+=  topping.calculateCalories();
        }
        return total;
    }

    public double getGetTotalCalories() {
        return totalCalories();
    }

    @Override
    public String toString() {
        return  String.format("%s - %.2f",this.name,this.getGetTotalCalories());
    }
}
