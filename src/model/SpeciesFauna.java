package model;

public class SpeciesFauna extends Species {

    private Boolean migratory;
    private double maxWeight;
   
    public SpeciesFauna(String name, String scientificName, SpeciesType type, Boolean migratory, double maxWeight) {
        super(name, scientificName, type);
        this.migratory = migratory;
        this.maxWeight = maxWeight;
    }

    public Boolean getMigratory() {
        return migratory;
    }

    public void setMigratory(Boolean migratory) {
        this.migratory = migratory;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }
}
