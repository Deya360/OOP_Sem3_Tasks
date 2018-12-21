package practicals.task8_2;

public interface OrdersManager {
    int itemQuantity(MenuItem menuItem);
    int itemQuantity(String itemName);
    Order[] getOrders();
    double ordersCostSummary();
    int ordersQuantity();
}
