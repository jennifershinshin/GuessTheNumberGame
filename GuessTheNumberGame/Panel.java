import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*****************************************************************
 * Panel is a JPanel that serves as a container to hold other objects. It has a button that allows
 * the user to reset the game. It also has a label that tells the user if their guess is too high
 * or low and if they won or lost the game.
 * 
 * @author: Jennifer Shin
 * @version: 4/26/14
 ****************************************************************/
public class Panel extends JPanel
{
    private Display display;
    private Scoreboard scoreboard;
    private JLabel label;
    private JButton reset;
    private int guess, target, tries;
    /************************************************************* 
     * Constructs a new Panel with a FlowLayout.
     **************************************************************/
    public Panel()
    {
        tries = 4;
        target = (int)(Math.random() * 25 + 1);

        setLayout(new BorderLayout());

        display = new Display(new Listener1());
        add(display, BorderLayout.CENTER);

        scoreboard = new Scoreboard();
        add(scoreboard, BorderLayout.NORTH);

        JPanel south = new JPanel();
        south.setLayout(new FlowLayout());
        add(south, BorderLayout.SOUTH);
        label = new JLabel("You have 4 tries to guess the number.");
        south.add(label);
        reset = new JButton("Reset");
        reset.setEnabled(false);
        reset.addActionListener(new Listener2());
        south.add(reset);
    }

    /************************************************************* 
     * Constructs a new private class that implements ActionListener. It tells what the corresponding
     * object should do when interacted with.
     **************************************************************/
    private class Listener1 implements ActionListener
    {
        /************************************************************* 
         * Determines if the user guessed right or wrong and implements the corresponding method.
         * Decreseases the user's tries by 1.
         * @param e     ActionEvent
         **************************************************************/
        public void actionPerformed(ActionEvent e)
        {
            JButton source = (JButton)e.getSource();
            guess = Integer.parseInt(source.getText());
            tries = tries - 1;
            if(guess == target)
                displayWinner();
            else if(tries == 0)
                displayLoser();
            else if(guess > target)
                displayTooHigh();
            else
                displayTooLow();
        }
    }

    /************************************************************* 
     * Constructs a new private class that implements ActionListener. It tells what the corresponding
     * object should do when interacted with.
     **************************************************************/
    private class Listener2 implements ActionListener
    {
        /************************************************************* 
         * Resets the game to how it was in the beginning. User gets 4 tries again to guess the
         * correct number. A new "correct" number is chosen. Finally, the reset button is disabled.
         * @param e       ActionEvent
         **************************************************************/
        public void actionPerformed(ActionEvent e)
        {
            display.reset();
            tries = 4;
            target = (int)(Math.random() * 25 + 1);
            label.setText("You have 4 tries to guess the number.");
            reset.setEnabled(false);
        }
    }

    /************************************************************* 
     * Disables all buttons in Display and changes label to inform user that he or she won the game.
     * Changes the clicked button to a green shade. Score is updated.
     **************************************************************/
    private void displayWinner()
    {
        display.displayWinner(target);
        label.setText("Congratulations, you picked the right number.");
        reset.setEnabled(true);
        scoreboard.score(true);
    }

    /************************************************************* 
     * Disables all buttons in Displayand changes label to inform user that he or she lost the game.
     * Enables the "reset" button. Score is updated.
     **************************************************************/
    private void displayLoser()
    {
        display.displayLoser(target);
        label.setText("Sorry, you lost the game.");
        reset.setEnabled(true);
        scoreboard.score(false);
    }

    /************************************************************* 
     * Changes label to inform user that the guess was too high. Turns the clicked button into
     * a red shade and disables it.
     **************************************************************/
    private void displayTooHigh()
    {
        display.displayTooHigh(guess);
        label.setText("Sorry, your guess was too high. You have " + tries + " to guess the number.");
    }

    /************************************************************* 
     * Changes label to inform user that the guess was too low. Turns the clicked button into a
     * blue shade and disables it.
     **************************************************************/
    private void displayTooLow()
    {
        display.displayTooLow(guess);
        label.setText("Sorry, your guess was too low. You have " + tries + " to guess the number.");
    }
}