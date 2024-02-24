package Objects.Plant;

import Objects.Fruit.Fruit;
import Objects.Poison.Poison;

import java.util.ArrayList;

public class Plant {

    private String genus;
    private String species;
    private String family;
    private String order;
    private String clade;
    private String subkingdom;

    private String lengthOfLife;
    private final ArrayList<String> environments;

    private final ArrayList<String> poisonousParts;
    private final ArrayList<String> states;
    private final ArrayList<Poison> poisons;
    private Fruit fruit;

    private double height;
    private double width;
    private double length;

    public Plant(String genus, String species, String family, String order, String clade, String subkingdom, String length_of_life, Fruit fruit, double height, double width, double length) {
        this.genus = genus;
        this.species = species;
        this.family = family;
        this.order = order;
        this.clade = clade;
        this.subkingdom = subkingdom;
        this.lengthOfLife = length_of_life;
        this.environments = new ArrayList<>();
        this.poisonousParts = new ArrayList<>();
        this.states = new ArrayList<>();
        this.poisons = new ArrayList<>();
        this.fruit = fruit;
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public Plant(String genus, String species){
       this.genus = genus;
       this.species = species;
       this.environments = new ArrayList<>();
       this.poisonousParts = new ArrayList<>();
       this.poisons = new ArrayList<>();
       this.states = new ArrayList<>();
    }

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getClade() {
        return clade;
    }

    public void setClade(String clade) {
        this.clade = clade;
    }

    public String getSubkingdom() {
        return subkingdom;
    }

    public void setSubkingdom(String subkingdom) {
        this.subkingdom = subkingdom;
    }

    public String getLengthOfLife() {
        return lengthOfLife;
    }

    public void setLengthOfLife(String lengthOfLife) {
        this.lengthOfLife = lengthOfLife;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public ArrayList<String> getEnvironments() {
        return environments;
    }

    public ArrayList<String> getPoisonousParts() {
        return poisonousParts;
    }

    public ArrayList<String> getStates() {
        return states;
    }

    public ArrayList<Poison> getPoisons() {
        return poisons;
    }

    public void addEnvironment(String environment){
        environments.add(environment);
    }

    public void addPoisonousPart(String poisonous_part){
        poisonousParts.add(poisonous_part);
    }

    public void addPoison(Poison poison){
        poisons.add(poison);
    }

    public void addState(String state){
        states.add(state);
    }
}
