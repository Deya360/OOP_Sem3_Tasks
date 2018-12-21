package practicals.task8_1;

import java.util.ArrayList;

public class Order {
    private int size;
    private ArrayList<Dish> dishes = new ArrayList<>();

    public Boolean add(Dish dish) {
        boolean res = dishes.add(dish);
        size = dishes.size();
        return res;
    }

    public Boolean remove(Dish dish) {
        boolean res = dishes.remove(dish);
        size = dishes.size();
        return res;
    }

    public int removeAll(Dish dish) {
        int prvSize = size;
        dishes.removeIf(s -> s.equals(dish));
        size = dishes.size();
        return prvSize-size;
    }

    public int dishQuantity() {

        return size;
    }

    public int dishQuantity(String dishName) {
        int count = 0;
        for (Dish d : dishes) {
            if (d.getName().equals(dishName)) count++;
        }
        return count;
    }

    public Dish[] getDishes() {
        return dishes.toArray(new Dish[size]);
    }

    public double costTotal() {
        double total = 0;
        for (Dish d : dishes) {
            total+= d.getCost();
        }
        return total;
    }

    public String dishNames() {
        StringBuilder returnTxt = new StringBuilder();
        returnTxt.append("Dishes: {");
        for (Dish d : dishes) {
            returnTxt.append(d.getName());
        }
        return returnTxt.toString();
    }

    public Dish[] getDishesByCostDesc() {
        ArrayList<Dish> returnArr = new ArrayList<>(dishes);

        returnArr.sort((d1, d2) -> {
            int value1 = Double.compare(d2.getCost(),d1.getCost());
            if (value1 == 0) {
                return  d1.getDescription().compareTo(d2.getDescription());
            }
            return value1;
        });

        return returnArr.toArray(new Dish[returnArr.size()]);
    }
}
