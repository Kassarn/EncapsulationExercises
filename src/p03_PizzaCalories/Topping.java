package p03_PizzaCalories;

import static p03_PizzaCalories.Main.CALORIES_PER_GRAM;

public class Topping {
    private static final double MEAT = 1.2;
    private static final double VEGGIES = 0.8;
    private static final double CHEESE = 1.1;
    private static final double SAUCE = 0.9;

    private String type;
    private double weight;

    public Topping(String type, double weight) {
        setType(type);
        setWeight(weight);
    }

    private void setType(String type) {
        if (!(type.toLowerCase().equals("meat") || type.toLowerCase().equals("veggies") ||
                type.toLowerCase().equals("cheese") || type.toLowerCase().equals("sauce"))) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", type));
        }
        this.type = type;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.type));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        switch (this.type.toLowerCase()) {
            case "meat":
                return (CALORIES_PER_GRAM * MEAT) * this.weight;
            case "veggies":
                return (CALORIES_PER_GRAM * VEGGIES) * this.weight;
            case "cheese":
                return (CALORIES_PER_GRAM * CHEESE) * this.weight;
            case "sauce":
                return (CALORIES_PER_GRAM * SAUCE) * this.weight;
                default:
                    return 0;
        }
    }
}
