package labs.task3;

public class Cutlery extends Tableware {

    public enum Type {
        Spoon,
        Fork,
        Knife;
    }
    private Type type;

    public Cutlery(Material material, String color, Type type) {
        super(material, color);
        this.type = type;
    }

    public Type getType() {return type;}
    public void setType(Type type) {this.type = type;}

    @Override public String toString() {
        return "labs.task3.Cutlery{" +
                "type=" + type +
                ", material=" + material +
                ", color='" + color + '\'' +
                '}';
    }
}
