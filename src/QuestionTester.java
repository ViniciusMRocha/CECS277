import java.util.Scanner;

public class QuestionTester {

//    static Scanner in = new Scanner(System.in);
//    /**
//     * Presents the question, accepts user-input and displays if answer is correct
//     * @param q
//     */
//    public static void presentQuestion(Question q) {
//        q.display();
//        System.out.println("Your response ");
//        String response = in.nextLine().trim(); //accepting keyboard input and trimming white space
//        //trailing whitespace.
//        if(q.checkAnswer(response)) {
//            System.out.println("Correct!");
//        }
//        else {
//            System.out.println("Sorry, Incorrect");
//        }
//    }

    public static void main(String[] args) {
        SCQuestion question = new SCQuestion("What day is it today?");
        question.addChoice("Monday",false);
        question.addChoice("Tuesday",false);
        question.addChoice("Your luck day",true);
        question.addChoice("Thursday",false);
        question.addChoice("Friday",false);

        question.presentQuestion();
    }
}
