import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*****************************************************************
 * A Display is a JPanel that contains 25 number buttons for the user to guess the number.
 * It knows how to reset all the number buttons to how it was in the beginning. It can also
 * disable all the number buttons and change the "winning" number button to a different
 * color if the user wins. If the user loses, it disables all number buttons and changes them
 * back to yellow, and changes the "winning" number buttonto orange. Lastly, it
 * changes the clicked button to a different color depending on how high or low the user's
 * guess is.

 * @author: Jennifer Shin
 * @version: 4/26/14
 ****************************************************************/
public class Display extends JPanel
{
    private JButton[] button;
    /************************************************************* 
     * Constructs a Display with a GridLayout. Creates a JButton for the "1-25" numbers.
     * Adds 25 buttons to the array.
     * @param lis       Assigns each button to an ActionListener
     **************************************************************/
    public Display(ActionListener lis)
    {
        setLayout(new GridLayout(5, 5, 5, 5));

        button = new JButton[25];
        for(int x = 0; x < 25; x++)
        {
            button[x] = new JButton("" + (x + 1));
            button[x].addActionListener(lis);
            button[x].setHorizontalAlignment(SwingConstants.CENTER);
            button[x].setFont(new Font("Serif", Font.BOLD, 20));
            button[x].setBackground(Color.yellow);
            add(button[x]);
        }
    }

    /************************************************************* 
     * Changes all the buttons to a yellow shade and also enables all the buttons.
     **************************************************************/
    public void reset()
    {
        for(int i=0; i<25; i++)
        {
            button[i].setBackground((Color.yellow));
            button[i].setEnabled(true);
        }
    }

    /************************************************************* 
     * Disables all the buttons and changes the color of the "winning" button to a
     * green shade.
     * @param target      Gets the "winning" number int.
     **************************************************************/
    public void displayWinner(int target)
    {
        for(int m=0; m<25; m++)
        {
            button[m].setEnabled(false);
        }
        button[target-1].setBackground((Color.green));
    }

    /************************************************************* 
     * Disables all the buttons and changes back all the buttons' colors to yellow. Changes the
     * "winning" number button to orange.
     **************************************************************/
    public void displayLoser(int target)
    {
        for(int m=0; m<25; m++)
        {
            button[m].setBackground((Color.yellow));
            button[m].setEnabled(false);
        }
        button[target-1].setBackground((Color.orange));
    }

    /************************************************************* 
     * Changes the guessed number button to a red shade and disables it.
     * @param guess    Gets the index of the guessed number in the array.
     **************************************************************/
    public void displayTooHigh(int guess)
    {
        button[guess-1].setBackground(Color.red);
        button[guess-1].setEnabled(false);
    }

    /************************************************************* 
     * Changes the guessed number button to a blue shade and disables it.
     * @param guess    Gets the index of the guessed number in the array.
     **************************************************************/
    public void displayTooLow(int guess)
    {
        button[guess-1].setBackground(Color.blue);
        button[guess-1].setEnabled(false);
    }
}