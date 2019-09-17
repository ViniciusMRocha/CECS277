import java.util.ArrayList;

/**
 * models a single-choice question with several options but only one correct
 */

public class SCQuestion extends Question{

    // instance variable
    private ArrayList<String> choices;

    // constructor
    public SCQuestion (String text) {
        super(text); //calling the overloaded constructor
                     //With a simple parameter
                     // the super class
        choices = new ArrayList<String>();
    }

    // added methods

    /**
     * Adds choices to this questions
     * @param choice - the new choice as a string
     * @param isCorrect - true if the given choice is correct, false otherwise
     */
    public void addChoice(String choice,boolean isCorrect) {
        choices.add(choice);
        if(isCorrect) {
            super.setAnswer(choice); //setting the correct answer
        }
    }

    // OVERRITTEN METHODS

    /**
     * Overrites the display() method in questions
     */
    @Override
    public void display() {
        super.display(); // diplaying the question next
        for (int i = 1; i<=choices.size();i++) {
            System.out.println(i+" "+choices.get(i-1));
        }
    }

    /**
     * Overridin the checkAnswer method from Question to access the appropriate response from the list of choices
     * @param option - the numeric selection form the list of options displayed as a String
     * @return - true if the section is correct, false otherwise
     */
    @Override
    public boolean checkAnswer(String option) { // name can change but data type has to be the same
        int s =Integer.parseInt(option); //Parsing frpm Sting to int
        String response = choices.get(s-1);
        return super.checkAnswer(response);
    }
}
