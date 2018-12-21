package labs.task4;

public class Animal implements Nameable {
    private String name;
    Animal(String name) {
        this.name =name;
    }

    @Override public String getName() {
        return this.name;
    }
}
