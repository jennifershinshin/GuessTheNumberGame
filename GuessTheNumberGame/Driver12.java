import javax.swing.JFrame;
/**
 * The "Guess The Number" game is a game that requires the user to guess a "winning" number from 1-25 to win the game.
 * The user only gets four tries to guess. When the user clicks the incorrect number (not equal to the "winning"
 * number), the game tells the user if their guess was too high or too low compared to the "winning" number. The game
 * also keeps track of how many times the user won out of the total number of games they played. Finally, the game
 * keeps track of the user's current winning streak and longest winning streak.
 * 
 * Jennifer Shin
 * 4/26/14
 */
public class Driver12
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Guess the Number");
        frame.setSize(800, 800);
        frame.setLocation(200, 100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Panel());
        frame.setVisible(true);
    }
}