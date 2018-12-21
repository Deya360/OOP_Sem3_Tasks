package practicals.task1;

public class Ball {
    private String name;
    public enum Types {
        Soccer(11.0),  // practicals.task1.Ball: Name(Radius)
        Basket(12.13),
        Tennis(3.429);

        private final double radius;

        Types(double radius) {
            this.radius = radius;
        }
        public double getRadius() {return this.radius;}

    }
    private Types type;

    private String manufacturer;
    private String color;
    private double radius;

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getType() {return type.toString();}
    public void setType(Types type) {
        this.type=type;
        setRadius();
    }

    public String getManufacturer() {return manufacturer;}
    public void setManufacturer(String manufacturer) {this.manufacturer = manufacturer;}

    public String getColor(){return color;}
    public void setColor(String color) {this.color = color;}

    public double getRadius(){return radius;}
    private void setRadius() {
        this.radius = type.getRadius();
    }

    Ball(String name, Types type, String manufacturer, String color){
        this.name=name;
        this.type=type;
        System.out.println();
        this.manufacturer=manufacturer;
        this.color=color;
        this.radius = type.getRadius();
    }

    public String toString(){
        return "It's a " + color + " " + type + "-ball called " + name +
                ", manufactured by " + manufacturer + " and has a radius of " + radius;
    }
}