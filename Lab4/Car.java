package labs.task4;

public class Car implements Nameable {
    private String name;
    Car(String name) {
        this.name =name;
    }

    @Override public String getName() {
        return this.name;
    }
}
