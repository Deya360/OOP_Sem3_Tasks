package labs.task3;

public class Main {

    public static void main(String [] args) {
        Main m = new Main();
        m.tester();
    }

    public void tester() {
//        labs.task3.Tableware t1 = new labs.task3.Tableware(labs.task3.Tableware.Material.Ceramic,"Orange");
//        System.out.println(t1);

        Plate p1 = new Plate(Tableware.Material.Ceramic,"White", Plate.Shape.Round,8.24);
        System.out.println(p1);

        Cutlery c1 = new Cutlery(Tableware.Material.Sterling_Silver,"Silver", Cutlery.Type.Knife);
        System.out.println(c1);
    }
}
