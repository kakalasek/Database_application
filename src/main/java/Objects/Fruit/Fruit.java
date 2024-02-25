package Objects.Fruit;

/**
 * Fruit object, used for further interaction
 */
public class Fruit {

    private String type;
    private String color;
    private String shape;

    public Fruit(String type, String color, String shape) {
        this.type = type;
        this.color = color;
        this.shape = shape;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }
}
