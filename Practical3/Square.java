package practicals.task3;

public class Square extends Rectangle{
    protected double side;

    public Square() {}
    public Square(double side) {this.side = side;}
    public Square(double side, String color, boolean filled) {super(color, filled, side, side); this.side = side;}

    public double getSide() {return side;}
    public void setSide(double side) {this.side = side;}

    public void setWidth(double width) {this.side = width;}
    public void setLength(double length) {this.side = length;}

    @Override public String toString() {
        return "practicals.task3.Square{" +
                "side=" + side +
                ", width=" + width +
                ", length=" + length +
                ", color='" + color + '\'' +
                ", filled=" + filled +
                '}';
    }
}
