package practicals.task8_2;

public class InternetOrdersManager implements OrdersManager {
    private QueueNode head;
    private QueueNode tail;
    private int size;

    public InternetOrdersManager() {size=0;}
    public InternetOrdersManager(MenuItem order) {}

    public boolean add(Order order) {
        QueueNode node = new QueueNode();

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        return true;
    }
    public Order remove(){
        Order dish = head.getValue();
        if (size != 0) {
            head = head.getNext();
            head.setPrevious(null);
            size--;
            return dish;
        }
        return dish;
    }
    public Order order() {return head.getValue(); }


    public int itemQuantity(String itemName) {
        int count = 0;
        QueueNode queue = head;
        if (size !=0) {
            for (int i = 0; i < size; i++) {
                count += queue.getValue().itemQuantity(itemName);
                queue = queue.getNext();
            }
            return count;
        }
        else return 0;
    }
    public int itemQuantity(MenuItem item) {
        int count = 0;
        QueueNode queue = head;
        if (size !=0) {
            for (int i = 0; i < size; i++) {
                count += queue.getValue().itemQuantity(item);
                queue = queue.getNext();
            }
            return count;
        }
        else return 0;
    }
    public double ordersCostSummary() {
        return 0;
    }
    public int ordersQuantity() {return size;}
    public Order[] getOrders() {
        return new Order[0];
    }
}

class QueueNode {
    private Order value;
    private QueueNode previous;
    private QueueNode next;

    public QueueNode getNext() {
        return next;
    }
    public void setNext(QueueNode next) {
        this.next = next;
    }

    public Order getValue(){
        return value;
    }
    public void setValue(Order value) {
        this.value=value;
    }

    public void setPrevious(QueueNode previous) {
        this.previous=previous;
    }
    public QueueNode getPrevious() {
        return previous;
    }
}

