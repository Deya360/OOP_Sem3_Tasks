package practicals.task8_1;

import java.util.ArrayList;
import java.util.Collections;

public class OrderManager {
    private ArrayList<Order> orders = new ArrayList<>(Collections.nCopies(51,null));

    public void add(Order order, int tableNumber) {
        orders.set(tableNumber,order);
    }

    public Order getOrder(int tableNumber) {
        return orders.get(tableNumber);
    }

    public void addDish(Dish dish, int tableNumber) {
        orders.get(tableNumber).add(dish);
    }

    public void removeOrder(int tableNumber) {
        orders.set(tableNumber,null);
    }

    public int freeTableNumber() {
        for (int i = 1; i < orders.size(); i++) {
            if(orders.get(i)==null) return i;
        }
        return orders.size();
    }

    public Integer[] freeTableNumbers() {
        ArrayList<Integer> returnArr = new ArrayList<>();
        for (int i = 1; i < orders.size(); i++) {
            if(orders.get(i)==null) returnArr.add(i);
        }
        if (returnArr.size()==0) returnArr.add(orders.size());

        return returnArr.toArray(new Integer[returnArr.size()]);
    }

    public Order[] getOrders() {
        ArrayList<Order> returnArr = new ArrayList<>();
        for (Order o : orders) {
            if(o!=null) returnArr.add(o);
        }

        return returnArr.toArray(new Order[returnArr.size()]);
    }

    public double ordersCostSummary() {
        double total = 0;
        for (Order o : orders) {
            if(o!=null) {
                for (Dish d : o.getDishes()) {
                    total+=d.getCost();
                }
            }
        }
        return total;
    }

    public int dishQuantinty(String dishName) {
        int count = 0;
        for (Order o : orders) {
            if(o!=null) {
                for (Dish d : o.getDishes()) {
                    if (d.getName().equals(dishName)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
