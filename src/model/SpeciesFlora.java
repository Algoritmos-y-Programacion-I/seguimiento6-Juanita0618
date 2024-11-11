package model;

public class SpeciesFlora extends Species {

    private Boolean flowers;
    private Boolean fruits;
    private double maxHeight;

    public SpeciesFlora(String name, String scientificName, SpeciesType type, Boolean flowers, Boolean fruits,
            double maxHeight) {
        super(name, scientificName, type);
        this.flowers = flowers;
        this.fruits = fruits;
        this.maxHeight = maxHeight;
    }

    public Boolean getFlowers() {
        return flowers;
    }

    public void setFlowers(Boolean flowers) {
        this.flowers = flowers;
    }

    public Boolean getFruits() {
        return fruits;
    }

    public void setFruits(Boolean fruits) {
        this.fruits = fruits;
    }

    public double getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(double maxHeight) {
        this.maxHeight = maxHeight;
    }

}
