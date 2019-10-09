import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class ExceptionDemo {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("The purpose of this program is to read a text file" +
                "\n Please enter the path and file name: ");
        String path = in.next(); //accept input

        File file = new File(path);
        // path for test: /Users/viniciusrocha/Desktop/README.txt

        try {
            Scanner fileReader = new Scanner(file);

            while (fileReader.hasNextLine()) {
                System.out.println(fileReader.nextLine()); //print the current line
            }


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        System.out.println("this should be regardless");

    }

}
