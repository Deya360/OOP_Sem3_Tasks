package practicals.task8_2;

import java.util.ArrayList;
import java.util.Collections;

public class TableOrdersManager implements OrdersManager{
    private ArrayList<Order> orders = new ArrayList<>(Collections.nCopies(51,null));

    public void add(Order order, int tableNumber) {
        orders.set(tableNumber, order);
    }
    public void addItem(MenuItem menuItem, int tableNumber) {
        orders.get(tableNumber).add(menuItem);
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
    public Order getOrder(int tableNumber) {
        return orders.get(tableNumber);
    }
    public void removeOrder(int tableNumber) {
        orders.set(tableNumber,null);
    }
    public Boolean remove(Order order) {
        return orders.remove(order);
    }
    public int removeAll(Order order) {
        int prvSize = orders.size();
        orders.removeIf(s -> s.equals(order));
        return prvSize-orders.size();
}

public int itemQuantity(String itemName) {
    int count = 0;
    for (Order o : orders) {
        if(o!=null) {
            for (MenuItem d : o.getItems()) {
                if (d.getName().equals(itemName)) {
                    count++;
                }
            }
        }
    }
    return count;
}
public int itemQuantity(MenuItem menuItem) {
    int count = 0;
    for (Order o : orders) {
        if(o!=null) {
            for (MenuItem d : o.getItems()) {
                if (d.equals(menuItem)) {
                    count++;
                }
            }
        }
    }
    return count;
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
            for (MenuItem d : o.getItems()) {
                total+=d.getCost();
            }
        }
    }
    return total;
}
    public int ordersQuantity() {return orders.size();}

}
