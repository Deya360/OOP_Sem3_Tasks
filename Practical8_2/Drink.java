package practicals.task8_2;

public final class Drink extends MenuItem implements Alcoholable {
    private double alcoholVol;
    private DrinkTypeEnum type;
    private static class DefaultVals {
        private static final double ALCOHOL_VOL = 0;
    }

    public Drink(String name, String description, double price, double alcoholVol, DrinkTypeEnum type) {
        super(name, description, price);
        this.alcoholVol = DefaultVals.ALCOHOL_VOL;
        this.type = type;
    }

    public DrinkTypeEnum getType() {return type;}

    public boolean isAlcoholicDrink() {return false;}
    public double getAlcoholVol() {return alcoholVol;}

    @Override public String toString() {
        return "practicals.task8_2.Drink{" +
                "alcoholVol=" + alcoholVol +
                ", type=" + type +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                '}';
    }
}

