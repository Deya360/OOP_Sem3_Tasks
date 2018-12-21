package practicals.task8_2;

public class InternetOrder implements Order {
    int size;
    ListNode head;
    ListNode tail;
    private Customer customer;
    MenuItem[] menuItems;
    private static final int SIZE = 16;

    InternetOrder() {}
    InternetOrder(MenuItem[] menuItems, Customer customer) {
        this.menuItems = menuItems;
        this.customer = customer;
    }

    public Boolean add(MenuItem dish) {
        ListNode node = new ListNode();

        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.setNext(node);
            tail = node;
        }
        return true;
    }

    public Boolean remove(MenuItem menuItem) {
        ListNode previous = null;
        ListNode current = head;if (current.getValue().equals(menuItem))
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                if (current.value.getName().equals(menuItem)) {
                    current.Remove(previous, current);
                    return true;
                }
                previous=current;
                current=current.getNext();
            }
        }
        return false;
    }

    public Boolean remove(String menuItem) {
        ListNode previous = null;
        ListNode current = head;
        if (current.getValue().getName().equals(menuItem)) {
            if (size != 0) {
                for (int i = 0; i < size; i++) {
                    if (current.value.getName().equals(menuItem)) {
                        current.Remove(previous, current);
                        return true;
                    }
                    previous = current;
                    current = current.getNext();
                }
            }
        }
        return false;
    }

    public int removeAll(MenuItem menuItem) {
        int count =0;
        ListNode current = head;
        ListNode previous = null;

        while (current!=null) {
            if (current.value.equals(menuItem)) {
                if (previous != null) {
                    previous.next = current.next;
                    current=null;
                    if (current.next == null) {
                        tail = previous;
                    }
                } else {
                    head = head.next;
                    if (head == null) {
                        tail = null;
                    }
                }
                size--;
                count++;
            }

            previous = current;
            current = current.getNext();
        }

        return count;
    }

    public int removeAll(String menuItemName) {
        ListNode current = head;
        ListNode previous = null;
        int count =0;

        while (current!=null) {
            if(current.value.getName().equals(menuItemName)){
                current.Remove(previous,current);
                count++;
            }
            previous=current;
            current=current.getNext();
        }
        return count;
    }

    public int itemQuantity() {
        return size;
    }

    public int itemQuantity(MenuItem menuItem) {
        return size;
    }

    public int itemQuantity(String itemName) {
        int count = 0;
        ListNode current = head;
        if (size != 0) {
            for (int i = 0; i < size; i++) {
                if (current.value.getName().equals(itemName))
                    count++;
                current = current.getNext();
            }
        }
        return count;
    }

    public MenuItem[] getItems() {
        MenuItem[] itemsClear = new MenuItem[size];
        ListNode current = head;
        for (int i = 0; i < size; i++) {
            itemsClear[i] = current.value;
            current = current.getNext();
        }
        return itemsClear;
    }

    public double costTotal() {
        double cost = 0;
        ListNode current = head;
        for (int i = 0; i < size; i++) {
            cost += current.value.getCost();
            current = current.getNext();
        }
        return cost;
    }

    public String[] itemNames() {
        int uniqNames = size;
        ListNode current = head;

        int t, unique = 1;
        while (current!=null ){
            t = 0;
            for (int j = 0; j < size - 1; j++)
                if (current.getNext()!= null &&(!current.value.getName().equals(current.getNext().value.getName())))
                    t++;
            current = current.getNext();
            if (t == 1)
                unique++;
        }
        String[] Names = new String[unique];
        current = head;
        for(int i=0;i<size;i++){
            Names[i] = current.value.getName();
            i++;
            current = current.getNext();
        }
        return Names;
    }

    public MenuItem[] sortedItemsByCostDesc() {
        MenuItem[] sortedDishes = getItems();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (sortedDishes[j].getCost() < sortedDishes[j + 1].getCost()) {
                    MenuItem tmp = sortedDishes[j];
                    sortedDishes[j] = sortedDishes[j + 1];
                    sortedDishes[j + 1] = tmp;
                }
            }
        }
        return sortedDishes;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override public String toString(){
        StringBuilder tableOrder = new StringBuilder("practicals.task8_2.InternetOrder: ");
        tableOrder.append(size+'\n');
        for(MenuItem o : menuItems) {
            tableOrder.append(o.toString()).append('\n');
        }
        return tableOrder.toString();
    }

}

class ListNode {
    public ListNode next;
    public MenuItem value;

    public ListNode getNext() {return next;}
    public void setNext(ListNode next) {this.next = next;}
    public void setValue(MenuItem node) {this.value = node;}
    public MenuItem getValue() {return value;}

    public void Remove(ListNode previous, ListNode current) {
        InternetOrder io = new InternetOrder();
        if (previous != null) {
            if (current.getNext() == null) {
                io.tail = previous;
            }
            previous.setNext(current.getNext());

        } else {
            if (io.head.next == null) {
                io.head = null;
                io.tail = null;
            }
            io.head = io.head != null ? io.head.next : null;
        }
        io.size--;
    }

}