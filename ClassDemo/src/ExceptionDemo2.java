import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionDemo2 {

    static Scanner in = new Scanner(System.in);

    public static void copyFile(String path, String filename) throws FileNotFoundException {


        File file = new File(path+filename);

        Scanner fileReader = new Scanner(file);

        PrintWriter fileWriter = new PrintWriter(path+" copy of: "+filename);

        while (fileReader.hasNextLine()){
            String currentLine = fileReader.nextLine();

            fileWriter.println(currentLine);
        }

        fileWriter.close();
        fileReader.close();
    }

    public static void main(String[] args) throws FileNotFoundException{
        System.out.println("Please enter the file path");
        String path = in.nextLine();
        System.out.println("Please enter the file name");
        String name = in.nextLine();

        copyFile(path, name);

        System.out.println("The program did not crash. Your file copy now exists");
    }
}

// path for test: /Users/viniciusrocha/Desktop/
// file name: README.txt
