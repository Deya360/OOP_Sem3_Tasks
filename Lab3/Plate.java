package labs.task3;

public class Plate extends Tableware{  //Tarelka

    public enum Shape {
        Round,
        Square,
        Squircle,
        Couple,
        Ribbon;
    }
    private Shape shape;
    private double radius;

    public Plate(Tableware.Material material, String color, Shape shape, double radius) {
        super(material, color);
        this.shape = shape;
        this.radius = radius;
    }

    public Shape getShape() {return shape;}
    public void setShape(Shape shape) {this.shape = shape;}

    public double getRadius() {return radius;}
    public void setRadius(double radius) {this.radius = radius;}

    @Override public String toString() {
        return "labs.task3.Plate{" +
                "material=" + material +
                ", color='" + color + '\'' +
                ", shape=" + shape +
                ", radius=" + radius + "cm" +
                '}';
    }
}
