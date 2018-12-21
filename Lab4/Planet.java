package labs.task4;

public class Planet implements Nameable {
    private String name;
    Planet(String name) {
        this.name =name;
    }

    @Override public String getName() {
        return this.name;
    }
}
