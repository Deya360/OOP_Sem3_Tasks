package practicals.task8_2;

public interface Order {
    Boolean add(MenuItem menuItem);

    String[] itemNames();
    int itemQuantity();
    int itemQuantity(MenuItem menuItem);
    int itemQuantity(String itemName);

    MenuItem[] getItems();
    Boolean remove(MenuItem menuItem);
    Boolean remove(String itemName);
    int removeAll(MenuItem menuItem);
    int removeAll(String itemName);
    MenuItem[] sortedItemsByCostDesc();

    double costTotal();
    Customer getCustomer();
    void setCustomer(Customer customer);

    String toString();
}