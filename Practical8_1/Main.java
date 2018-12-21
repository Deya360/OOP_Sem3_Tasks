package practicals.task8_1;

public class Main {

    public static void main(String[] args) {    //Driver sub
        Dish d1 = new Dish("Biryani","a mixed rice dish with its origins among the Muslims of the Indian subcontinent.",20.0);
        Dish d2 = new Dish("Foul meddamas","a dish of cooked fava beans served with vegetable oil, cumin, and optionally with chopped parsley, garlic, onion, lemon juice, chili pepper and other vegetable, herb and spice ingredients.",12.5);
        Dish d3 = new Dish("Falafel","is a deep-fried ball, doughnut, or patty made from ground chickpeas, fava beans, or both.",5.0);
        Dish d4 = new Dish("Tabouleh","a Levantine vegetarian salad made mostly of finely chopped parsley, with tomatoes, mint, onion, bulgur, and seasoned with olive oil, lemon juice, salt and pepper.",7.5);

        Order o1 = new Order();
        o1.add(d3);
        o1.add(d2);
        o1.add(d4);
        Order o2 = new Order();
        o2.add(d4);
        o2.add(d4);
        o2.add(d4);
        Order o3 = new Order();
        o3.add(d1);
        o3.add(d2);
        o3.add(d3);
        o3.add(d4);
        Order o4 = new Order();
        o4.add(d3);

        OrderManager oM1 = new OrderManager();
        oM1.add(o2,1);
        oM1.add(o2,3);

        System.out.println(oM1.ordersCostSummary());

    }

}