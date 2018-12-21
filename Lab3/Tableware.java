package labs.task3;

public class Tableware { //Dish

    public enum Material {
        Ceramic,
        Glass,
        Wood,
        Metal,
        Plastic,
        Porcelain,
        Sterling_Silver,
        Steel;
    }
    protected Material material;
    protected String color;

    public Tableware(Material material, String color) {
        this.material = material;
        this.color = color;
    }

    public Material getMaterial() {return material;}
    public void setMaterial(Material material) {this.material = material;}

    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}

    @Override public String toString() {
        return "labs.task3.Tableware{" +
                "material=" + material +
                ", color='" + color + '\'' +
                '}';
    }
}