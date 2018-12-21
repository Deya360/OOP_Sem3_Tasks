package practicals.task8_2;

abstract class MenuItem {
    String name;
    String description;
    double cost;
    public static final double COST = 0;

    public MenuItem(String name, String description) {
        this.name = name;
        this.description = description;
        this.cost = COST;
    }

    public MenuItem(String name, String description, double cost) {
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    public String getName() {return name;}
    public String getDescription() {return description;}
    public double getCost() {return cost;}

    @Override public String toString() {
        return "practicals.task8_2.MenuItem{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }
}
