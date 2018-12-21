package practicals.task8_1;

public final class Dish {
    private final String name;
    private final String description;
    private final double cost;
    private static class DefaultVals {
        private static final double price = 0;
    }

    public Dish(String name, String description) {
        this.name = name;
        this.description = description;
        this.cost = Dish.DefaultVals.price;
    }

    public Dish(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.cost = price;
    }

    public String getName() {return name;}
    public String getDescription() {return description;}
    public double getCost() {return cost;}

    @Override public String toString() {
        return "practicals.task8_1.Dish{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }
}
