package practicals.task8_2;

public final class Dish extends MenuItem {
    private final String name;
    private final String description;
    private final double cost;
    private static class DefaultVals {
        private static final double COST = 0;
    }

    public Dish(String name, String description, String name1, String description1, double cost) {
        super(name, description);
        this.name = name1;
        this.description = description1;
        this.cost = Dish.DefaultVals.COST;
    }

    public Dish(String name, String description, double price, String name1, String description1, double cost) {
        super(name, description, price);
        this.name = name1;
        this.description = description1;
        this.cost = cost;
    }

    public String getName() {return name;}
    public String getDescription() {return description;}
    public double getCost() {return cost;}

    @Override public String toString() {
        return "practicals.task8_2.Dish{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }
}
