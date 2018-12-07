package p03_PizzaCalories;

import static p03_PizzaCalories.Main.CALORIES_PER_GRAM;

public class Dough {
    private static final double WHITE = 1.5;
    private static final double WHOLEGRAIN = 1.0;

    private static final double CRISPY = 0.9;
    private static final double CHEWY = 1.1;
    private static final double HOMEMADE = 1.0;



    private String flourType; /*white or wholegrain*/
    private double weight;
    private String bakingTechnique; /*crispy, chewy or homemade*/

    public Dough(String flourType, double weight, String bakingTechnique) {
        setFlourType(flourType);
        setWeight(weight);
        setBakingTechnique(bakingTechnique);
    }


    private void setFlourType(String flourType) {
        if (!(flourType.toLowerCase().equals("white") || flourType.toLowerCase().equals("wholegrain"))) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        if (!(bakingTechnique.toLowerCase().equals("chewy") || bakingTechnique.toLowerCase().equals("crispy")
                || bakingTechnique.toLowerCase().equals("homemade"))) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {

        switch (this.flourType.toLowerCase()) {
            case "white":
                switch (this.bakingTechnique.toLowerCase()) {
                    case "crispy":
                        return (CALORIES_PER_GRAM * this.weight) * WHITE * CRISPY;
                    case "chewy":
                        return (CALORIES_PER_GRAM * this.weight) * WHITE * CHEWY;
                    case "homemade":
                        return (CALORIES_PER_GRAM * this.weight) * WHITE * HOMEMADE;
                }
            case "wholegrain":
                switch (this.bakingTechnique.toLowerCase()) {
                    case "crispy":
                        return (CALORIES_PER_GRAM * this.weight) * WHOLEGRAIN * CRISPY;
                    case "chewy":
                        return (CALORIES_PER_GRAM * this.weight) * WHOLEGRAIN * CHEWY;
                    case "homemade":
                        return (CALORIES_PER_GRAM * this.weight) * WHOLEGRAIN * HOMEMADE;
                }
            default:
                return 0;
        }
    }
}
