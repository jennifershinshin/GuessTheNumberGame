import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.text.DecimalFormat;
/**
 * A Scoreboard is a JPanel that contains informatino about the user's score in the game.
 * It displays and keeps track of the number of times the user has won and the total number
 * of games the user played. In addition, it displays the user's winning percentage. Also, it
 * can update the user's current winning streak and longest streak.
 * 
 * @author Jennifer Shin
 * @version 4/27/14
 */
public class Scoreboard extends JPanel
{
    private JPanel scoreboard;
    private JLabel label1, label2, label3, winsL, currStrL, longStrL;
    private int wins, currentStr, longestStr, total;
    private double winsPercent;
    /************************************************************* 
     * Constructs a Scoreboard with 6 labels to display the "wins", "current streak", and
     * "longest streak".
     **************************************************************/
    public Scoreboard()
    {
        setLayout(new GridLayout(1,6));

        label1 = new JLabel("Wins: ");
        label2 = new JLabel("Current Streak: ");
        label3 = new JLabel("Longest Streak: ");
        winsL = new JLabel(wins + "/" + total + " (" + winsPercent + "%)");
        currStrL = new JLabel("" + currentStr);
        longStrL = new JLabel("" + longestStr);
        add(label1);
        add(winsL);
        add(label2);
        add(currStrL);
        add(label3);
        add(longStrL);
    }

    /************************************************************* 
     * Updates the score. It increases total by 1. If the user wins, it increases the "wins"
     * int and the "current streak" int by 1. If the user loses, it sets the "current streak"
     * int to 0. It also updates the "winning" percentage and reduce it to 2 decimal places.
     * @param bool       Determines if the game was won or lost.
     **************************************************************/
    public void score(boolean bool)
    {
        DecimalFormat decformat = new DecimalFormat("00.00");
        total++;
        if(bool==true)
        {
            wins++;
            currentStr++;
            longestUpdate();
        }
        else
        {
            currentStr=0;
        }
        winsPercent=wins*100.0/total;
        String s = decformat.format(winsPercent);
        winsL.setText(wins + "/" + total + " (" + s + "%)");
        currStrL.setText("" + currentStr);
        longStrL.setText("" + longestStr);
    }

    /************************************************************* 
     * Updates the "longest streak" int. If the current streak int is greater than the
     * longest streak int, it equals the "longest streak" int to the "current streak" int.
     **************************************************************/
    public void longestUpdate()
    {
        if(currentStr>longestStr)
        {
            longestStr=currentStr;
        }
    }
}
