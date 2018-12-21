package practicals.task3;

public class Main {
    public static void main(String[] args) { //Tester-Sub
        Shape s1 = new Circle("GREEN",false,7.2);  //upcast
        System.out.println(s1);
        System.out.println(s1.getArea());
        System.out.println(s1.getPerimeter());
        System.out.println(s1.getColor());
        System.out.println(s1.isFilled()+"\n\n");

        Circle c1 = (Circle)s1;   //downcast
        System.out.println(c1);
        System.out.println(c1.getArea());
        System.out.println(c1.getPerimeter());
        System.out.println(c1.getColor());
        System.out.println(c1.isFilled());
        System.out.println(c1.getRadius()+"\n\n");


        Shape s2 = new Rectangle("YELLOW",true, 4.5,3.5);
        System.out.println(s2);
        System.out.println(s2.getArea());
        System.out.println(s2.getPerimeter());
        System.out.println(s2.getColor());
        System.out.println(s2.isFilled()+"\n\n");

        Rectangle r1 = (Rectangle)s2;
        System.out.println(r1);
        System.out.println(r1.getArea());
        System.out.println(r1.getPerimeter());
        System.out.println(r1.getColor());
        System.out.println(r1.isFilled());
        System.out.println(r1.getWidth());
        System.out.println(r1.getLength()+"\n\n");


        Shape s3 = new Square(7.2,"Yellow",true);
        System.out.println(s3);
        System.out.println(s3.getColor());
        System.out.println(s3.isFilled()+"\n\n");

        Rectangle r2 = (Rectangle)s3;
        System.out.println(r2);
        System.out.println(r2.getArea());
        System.out.println(r2.getColor());
        System.out.println(r2.isFilled()+"\n\n");

        Square sq1 = (Square)s3;
        System.out.println(sq1);
        System.out.println(sq1.getColor());
        System.out.println(sq1.isFilled());
        System.out.println(sq1.getSide());
    }
}
