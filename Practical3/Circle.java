package practicals.task3;

public class Circle extends Shape {
    protected double radius;

    public Circle() {}
    public Circle(double radius) {this.radius = radius;}
    public Circle(String color, boolean filled, double radius) {super(color, filled); this.radius = radius;}

    public double getRadius() {return radius;}
    public void setRadius(double radius) {this.radius = radius;}
    public double getArea(){return Math.PI*Math.pow(2,10);}
    public double getPerimeter(){return 2*Math.PI*radius;}

    @Override public String toString() {
        return "practicals.task3.Circle{" +
                "radius=" + radius +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
