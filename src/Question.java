import java.util.Scanner;

/**
 * models a question with a question text and answer
 * @author Katherine Varela
 * @version 1.0.0
 * **/
public class Question {

    private String text;
    private String answer;

    /**
     * constructs an empty question
     * */
    public Question() {
        text = "";
        answer = "";
    }

    /**
     * constructs a question with given text, but no answer
     * @param text - the question text as a string
     * */
    public Question(String text) {
        this.text = text;
    }

    /**
     * constructs a question with given text and correct answer
     * @param text - the question text as a string
     * @param answer - the correct answer as a string
     * */
    public Question(String text, String answer) {
        this.text = text;
        this.answer = answer;
    }

    /**
     * sets the question text to the given text
     * @param newText - the new question text
     * */
    public void setText(String newText) {
        this.text = newText;
    }

    /**
     * sets the question answer to the given answer
     * @param newAnswer - the new question answer
     * */
    public void setAnswer(String newAnswer) {
        this.answer = newAnswer;
    }

    /**
     * checks the given response for correctness
     * @param response - the response to check for correctness
     * @return true if response is the correct answer to this Question
     * */
    public boolean checkAnswer(String response) {
        return answer.equalsIgnoreCase(response);
    }


    /**
     * displays the text of this question
     * */
    public void display() {
        System.out.println(this.text);
    }



    /*
     * main method
     * */
    public static void main(String[] args) {

        Question q = new Question("What is the capital of Canada?","Ottowa");
        q.display();
        System.out.print("Your response: ");

        Scanner in = new Scanner(System.in);
        String response = in.nextLine();
        if(q.checkAnswer(response)) {
            System.out.println("Correct!");
        }
        else {
            System.out.println("Sorry that is incorrect.");
        }
    }
}
