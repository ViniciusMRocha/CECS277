import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

/**
 * models a question with a question text and answer
 * @author Katherine Varela
 * @version 1.0.0
 * **/
public class Question implements Comparable{

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

    /**
     * returns the question and correct answer
     * @return returns the question and correct answer in a String
     */

    public String toString() {
        return "Q: "=this.text+'\nA: '+this.answer;
    }

    public int compareTo(Object obj) {
        Question otherQ = (Question) obj; // Typecasting into a Question type
        return this.text.compareTo(otherQ.text);
    }

    /**
     * Displays the question, accepts the user response, and give
     */
    public void presentQuestion() {
        this.display(); // this is the implicit parameter used to denote that a method is acting on the current object
                        // "this" acts on the current object
        System.out.println("Your response ");
        Scanner in = new Scanner(System.in);
        String response = in.nextLine().trim(); //accepting keyboard input and trimming white space
        //trailing whitespace.
        if(this.checkAnswer(response)) {
            System.out.println("Correct!");
        }
        else {
            System.out.println("Sorry, Incorrect");
        }
    }


    /**
     * main method
     * */
    public static void main(String[] args) {

        Question w = new Question("What is the capital of Canada?","Ottowa");
        Question a = new Question("What time is class over","2:50");
        Question b = new Question("Between what two integers is number 2.3?","2 and 3");

        ArrayList<Question> question = new ArrayList<Question>();
        question.add(w);
        question.add(a);
        question.add(b);

        System.out.println("Before sort: "+question);
        Collections.sort(question);
        System.out.println("After sort: "+question);

    }


}
