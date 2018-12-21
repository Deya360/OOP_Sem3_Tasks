package practicals.task8_2;

import java.util.ArrayList;

public class TableOrder implements Order {
    private int size;
    private ArrayList<MenuItem> menuItems = new ArrayList<>();
    private Customer customer;

    public Boolean add(MenuItem menuItem) {
        boolean res = menuItems.add(menuItem);
        size = menuItems.size();
        return res;
    }

    public Boolean remove(MenuItem menuItem) {
        boolean res = menuItems.remove(menuItem);
        size = menuItems.size();
        return res;
    }

    public Boolean remove(String itemName) {
        int prvSize = size;
        for (MenuItem d : menuItems) {
            if (d.getName().equals(itemName)) {
                menuItems.remove(d);
                break;
            }
        }
        size = menuItems.size();
        return prvSize!=size;
    }

    public int removeAll(MenuItem menuItem) {
        int prvSize = size;
        menuItems.removeIf(s -> s.equals(menuItem));
        size = menuItems.size();
        return prvSize-size;
    }

    public int removeAll(String itemName) {
        int prvSize = size;
        menuItems.removeIf(s -> s.getName().equals(itemName));
        size = menuItems.size();
        return prvSize-size;
    }

    public int itemQuantity() {
        return size;
    }

    public int itemQuantity(MenuItem menuItem) {
        return size;
    }

    public int itemQuantity(String dishName) {
        int count = 0;
        for (MenuItem d : menuItems) {
            if (d.getName().equals(dishName)) count++;
        }
        return count;
    }

    public MenuItem[] getItems() {
        return menuItems.toArray(new MenuItem[size]);
    }

    public double costTotal() {
        double total = 0;
        for (MenuItem d : menuItems) {
            total+= d.getCost();
        }
        return total;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String[] itemNames() {
        ArrayList<String> returnArr = new ArrayList<>();
        StringBuilder returnTxt = new StringBuilder();
        returnTxt.append("Dishes: {");
        for (MenuItem d : menuItems) {
            returnArr.add(d.getName());
        }
        return returnArr.toArray(new String[returnArr.size()]);
    }

    public MenuItem[] sortedItemsByCostDesc() {
        ArrayList<MenuItem> returnArr = new ArrayList<>(menuItems);

        returnArr.sort((d1, d2) -> {
            int value1 = Double.compare(d2.getCost(),d1.getCost());
            if (value1 == 0) {
                return  d1.getDescription().compareTo(d2.getDescription());
            }
            return value1;
        });

        return returnArr.toArray(new MenuItem[returnArr.size()]);
    }
}
