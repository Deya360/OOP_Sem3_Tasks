package labs.task8;
public class Main {
    public static void main(String[] args) {  //Driver Sub
        FileHandler fh1 = new FileHandler("text1.txt");
        fh1.writeFile("Hello");
        fh1.readFile();

        fh1.appendToFile("It's A Me, MARIO!\n");
        fh1.readFile();

        fh1.replaceInFile("MARIO","LUIGI");
        fh1.readFile();
    }
}
