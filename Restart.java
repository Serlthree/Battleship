import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Restart implements ActionListener {
//Restarts the entire board

    @Override
    public void actionPerformed(ActionEvent e) {
        repaintOpponentBoard();
        repaintUserBoard();
        repaintHiddenOpponentBoard();
        AddingComputerShips.actionPerformed();
        returnShips();
        changeDifficulty();
    }

    //sets OpponentBoard back to original state
    private void repaintOpponentBoard() {
        for(int r = 0; r < 10; r++){
            for(int c = 0; c < 10; c++){
                BattleshipGUI.opponentArray[r][c].setBackground(BattleshipGUI.water);
            }
        }
    }
    //sets playerBoard back to original state
    private void repaintUserBoard() {
        for(int r = 0; r < 10; r++){
            for(int c = 0; c < 10; c++){
                BattleshipGUI.playerArray[r][c].setBackground(BattleshipGUI.water);
            }
        }
    }
    //sets ActualOpponentBoard back to original state
    private void repaintHiddenOpponentBoard() {
        for(int r = 0; r < 10; r++){
            for(int c = 0; c < 10; c++){
                BattleshipGUI.hiddenComputerArray[r][c].setBackground(BattleshipGUI.water);
            }
        }
    }
    //sets back the shipCount
    private void returnShips() {
        AddingShips.numTwoWidthShips = 1;
        AddingShips.numThreeWidthShips = 2;
        AddingShips.numFourWidthShips = 1;
        AddingShips.numFiveWidthShips = 1;
    }

    private void changeDifficulty() {
        String difficulty = JOptionPane.showInputDialog("Enter Difficulty (Easy, Medium, Hard)");
        if(difficulty.equalsIgnoreCase("easy")){
            BattleshipGUI.difficultyMod = 7;
        }
        else if (difficulty.equalsIgnoreCase("medium")){
            BattleshipGUI.difficultyMod = 6;
        }
        else{
            BattleshipGUI.difficultyMod = 5;
        } 
    }
}
