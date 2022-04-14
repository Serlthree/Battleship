public class AddingComputerShips{
    //every method is static because I was too lazy to create an AddingComputerShips object
    private static ArrayList<Integer> shipWidth = new ArrayList<Integer>();
    
    private static int NORTH = 0;
    private static int SOUTH = 1;
    private static int EAST = 2;
    private static int WEST = 3;
    
    //adds computer ships
    public static void actionPerformed() {
        fillShipArray();
        while(totalShipsLeft() != 0){
            int width = shipWidth.remove(0);
            buildShips(width);
        }
    }
    
    //counts total number of ships
    private static int totalShipsLeft(){
        return shipWidth.size();
    }
    
    //the meat of buildShips method, builds a ship with a random row, column, and direction given the width
    private static void buildShips(int width) {
        int randomRow = (int)(Math.random()*10);
        int randomCol = (int)(Math.random()*10);
        int randomDirection = (int)(Math.random()*4);
            if(isValid(width,randomRow,randomCol,randomDirection)){
                for(int i = 0; i < width; i++){
                    if(randomDirection == NORTH){
                        BattleshipGUI.hiddenComputerArray[randomRow-i][randomCol].setBackground(BattleshipGUI.battleship);
                    }
                    else if (randomDirection == SOUTH){
                        BattleshipGUI.hiddenComputerArray[randomRow+i][randomCol].setBackground(BattleshipGUI.battleship);
                    }
                    else if (randomDirection == EAST){
                        BattleshipGUI.hiddenComputerArray[randomRow][randomCol+i].setBackground(BattleshipGUI.battleship);
                    }
                    else{
                        BattleshipGUI.hiddenComputerArray[randomRow][randomCol-i].setBackground(BattleshipGUI.battleship);
                    }
                }
            }
            else
                buildShips(width);
    }

    //Used a array to fill ships in instead of the player addingships because arraylists are easier to manipulate than 4 seperate integers
    private static void fillShipArray() {
            for(int i = 0; i < 5; i++){
                if(i == 0){
                    shipWidth.add(2);
                }
                else if (i == 1 || i == 2){
                    shipWidth.add(3);
                }
                else if (i == 3){
                    shipWidth.add(4);
                }
                else
                    shipWidth.add(5);
            }
    }

    //checks to see if AI moves are valid or not
    private static boolean isValid(int w, int r, int c, int d) {
        for(int i = 0; i < w; i++){
            if(d == NORTH){
                if(r - i < 0 || BattleshipGUI.hiddenComputerArray[r-i][c].getBackground() == BattleshipGUI.battleship){
                    return false;
                }
            }
            else if (d == SOUTH){
                if(r + i > 9 || BattleshipGUI.hiddenComputerArray[r+i][c].getBackground() == BattleshipGUI.battleship){
                    return false;
                }
            }
            else if (d == EAST){
                if(c + i > 9 || BattleshipGUI.hiddenComputerArray[r][c+i].getBackground() == BattleshipGUI.battleship){
                    return false;
                }
            }
            else if (d == WEST){
                if(c - i < 0 || BattleshipGUI.hiddenComputerArray[r][c-i].getBackground() == BattleshipGUI.battleship){
                    return false;
                }            
            }
        }
        return true;
    }
    
}
