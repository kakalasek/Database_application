package Objects.Poison;

import java.util.ArrayList;

public class Poison {

    private String name;
    private String group;
    private final ArrayList<String> effects;

    public Poison(String name, String group, double ld50) {
        this.name = name;
        this.group = group;
        this.effects = new ArrayList<>();
        this.ld50 = ld50;
    }

    private double ld50;

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public ArrayList<String> getEffects() {
        return effects;
    }

    public double getLd50() {
        return ld50;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public void setLd50(double ld50) {
        this.ld50 = ld50;
    }

    public void addEffect(String effect){
        effects.add(effect);
    }
}
