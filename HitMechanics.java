public class HitMechanics implements ActionListener {
    //battleship is a turn based game
    private int turn = 0;
    private int AIturn = 0;
    
    //checks to see if ships are hit
    private boolean hitsOpponentShip(int r, int c) {
        return BattleshipGUI.hiddenComputerArray[r][c].getBackground() == BattleshipGUI.battleship;
    }
    
    private boolean hitsPlayerShip(int r, int c) {
        return BattleshipGUI.playerArray[r][c].getBackground() == BattleshipGUI.battleship;
    }
    
    //does the updating if player hits or misses
    private void processClick(int r, int c) {
        if(hitsOpponentShip(r,c)){
            BattleshipGUI.opponentArray[r][c].setBackground(BattleshipGUI.hit);
        }
        else{
            BattleshipGUI.opponentArray[r][c].setBackground(BattleshipGUI.miss);
        }
    }
    
    //does action when preformed by button
    public void actionPerformed(ActionEvent e){
        //Victory screen
        checkVictory();
        //processes location of click and invokes processClick
        if(AddingShips.totalShipsLeft() == 0){
            if(turn%2 == 0){
                Object source = e.getSource();
                for(int r = 0; r < 10; r++){
                    for(int c = 0; c < 10; c++){
                        if(source == BattleshipGUI.opponentArray[r][c]){
                            processClick(r,c);
                            turn++;
                            AIturn++;
                        }
                    }
                }
            }
            //invokes computerMove when it's the computer's turn
            else{
                computerMove();
                turn++;
            }   
        }
    }

    private void computerMove() {
        //not a particularly smart AI, so it guesses squares by random chance (and also cheats to make it competitive)
        int randomRow = (int)(Math.random()*10);
        int randomCol = (int)(Math.random()*10);
        if(AIturn % BattleshipGUI.difficultyMod == 0){
            for(int r = 0; r < 10; r++){
                for(int c = 0; c < 10; c++){
                    if(BattleshipGUI.playerArray[r][c].getBackground() == BattleshipGUI.battleship){
                        randomRow = r;
                        randomCol = c;
                    }
                }
            }
        }
        //checks for the color to determine whether it hits or misses
        if(hitsPlayerShip(randomRow, randomCol)){
            BattleshipGUI.playerArray[randomRow][randomCol].setBackground(BattleshipGUI.hit);
        }
        //moves again if it hits a tile that's already hit or misses
        else if(BattleshipGUI.playerArray[randomRow][randomCol].getBackground() == BattleshipGUI.hit ||BattleshipGUI.playerArray[randomRow][randomCol].getBackground() ==  BattleshipGUI.miss){
            computerMove();
        }
        else
            BattleshipGUI.playerArray[randomRow][randomCol].setBackground(BattleshipGUI.miss);
    }

    //goes through the array, checks the total number of gray squares (battleships) left and if one side has 0 they win.
    private void checkVictory() {
        int playerNumGray = 17;
        int computerNumGray = 17;
        for(int r = 0; r < 10; r++){
            for(int c = 0; c < 10; c++){
                if(BattleshipGUI.playerArray[r][c].getBackground() == BattleshipGUI.hit){
                    playerNumGray--;
                }
                if(BattleshipGUI.opponentArray[r][c].getBackground() == BattleshipGUI.hit){
                    computerNumGray--;
                }
            }
        }
        if(playerNumGray == 0){
            JOptionPane.showMessageDialog(null, "You Lost!", "You Lost!", INFORMATION_MESSAGE);
        }
        else if(computerNumGray == 0){
            JOptionPane.showMessageDialog(null, "You Won!", "You Won!", INFORMATION_MESSAGE);
        }
    }
    
}
