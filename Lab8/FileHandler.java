package labs.task8;
import java.io.*;

public class FileHandler {
    private String filePath;
    public FileHandler(String filePath) {this.filePath = filePath;}

    public void readFile() {
        String line;
        try {
            FileReader fileReader = new FileReader(filePath);

            BufferedReader bufferedReader = new BufferedReader(fileReader);
            System.out.println("Data in file:");
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
            bufferedReader.close();

        } catch(FileNotFoundException ex) {System.out.println("\nUnable to open file '" + filePath + "'");
        } catch(IOException ex) {System.out.println("\nError reading file '"+ filePath + "'");
        }
    }

    public void writeFile(String writeTxt) {
        if (fileWrite(writeTxt,false)) System.out.println("\nData was successfully written to file.");
    }

    public void replaceInFile(String oldStr, String newStr) {
        String line, newData = "";
        StringBuilder sb = new StringBuilder(newData);
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line.replaceAll(oldStr, newStr)).append("\n");
            }
            bufferedReader.close();
            if (fileWrite(sb.toString(),false)) System.out.println("\nData in file was successfully replaced.");

        } catch(FileNotFoundException ex) {System.out.println("\nUnable to open file '" + filePath + "'");
        } catch(IOException ex) {System.out.println("\nError reading file '"+ filePath + "'");
        }
    }

    public void appendToFile(String appendTxt) {
        if (fileWrite(appendTxt,true)) System.out.println("\nData was successfully appended to file.");
    }

    private boolean fileWrite(String data, boolean appendB) {
        try {
            FileWriter fileWriter = new FileWriter(filePath,appendB);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String lines[] = data.split("[\\r\\n]+");
            for (String strTemp : lines){
                bufferedWriter.write(strTemp + System.lineSeparator());
            }
            bufferedWriter.close();
            return true;

        } catch(IOException ex) {
            System.out.println("\nError writing to file '"+ filePath + "'");
            return false;
        }
    }
}
