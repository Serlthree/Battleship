public class AddingShips implements ActionListener{
    public static int numTwoWidthShips = 1;
    public static int numThreeWidthShips = 2;
    public static int numFourWidthShips = 1;
    public static int numFiveWidthShips = 1;
    
    private final String[] shipOptions = {"Build Ships", "Cancel"};
    
    private int NORTH = 0;
    private int SOUTH = 1;
    private int EAST = 2;
    private int WEST = 3;

    //gets responses from user using OptionPanes and uses them, also draws the ship
    public void actionPerformed(ActionEvent e) {
        int response = JOptionPane.showOptionDialog(null, "Number of two width ships: " + numTwoWidthShips + 
                "\n Number of three width ships: " + numThreeWidthShips + 
                "\n Number of four width ships: " + numFourWidthShips + 
                "\n Number of five width ships: " + numFiveWidthShips,
                "Number of Ships", OK_CANCEL_OPTION, INFORMATION_MESSAGE,null,shipOptions,null);
        if(response == JOptionPane.OK_OPTION){
            String widthOfPlacedShip = JOptionPane.showInputDialog("Enter Width of Placed Ship");
            String row = JOptionPane.showInputDialog("Enter Row (First row is at 0)");
            String column = JOptionPane.showInputDialog("Enter Column (First column is at 0)");
            int r = Integer.parseInt(row);
            int c = Integer.parseInt(column);
            int width = Integer.parseInt(widthOfPlacedShip);
            String PositionString = JOptionPane.showInputDialog("Enter Orientation of Ship (North, South, East, West).");
            if(PositionString.equalsIgnoreCase("north")){
                drawShip(r, c, width,NORTH);
            }
            else if(PositionString.equalsIgnoreCase("south")){
                drawShip(r, c, width,SOUTH);
            }
            else if(PositionString.equalsIgnoreCase("east")){
                drawShip(r, c, width,EAST);
            }
            else
                drawShip(r, c, width,WEST);
            
        }
        
    }

    //draws the ship, has error message if user tries to go over ship count
    private void drawShip(int r, int c, int width, int direction) {
        if(isValid(width, r, c, direction)){
            for(int i = 0; i < width; i++){
                if(direction == NORTH){
                    BattleshipGUI.playerArray[r-i][c].setBackground(BattleshipGUI.battleship);
                }
                else if (direction == SOUTH){
                    BattleshipGUI.playerArray[r+i][c].setBackground(BattleshipGUI.battleship);
                }
                else if (direction == EAST){
                    BattleshipGUI.playerArray[r][c+i].setBackground(BattleshipGUI.battleship);
                }
                else
                    BattleshipGUI.playerArray[r][c-i].setBackground(BattleshipGUI.battleship);
        }
            if(width == 2){
                numTwoWidthShips--;
            }
            else if(width == 3){
                numThreeWidthShips--;
            }
            else if(width == 4){
                numFourWidthShips--;
            }
            else if(width == 5){
                numFiveWidthShips--;
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null, "You have entered an invalid input. Please try again.", "ERROR: INVALID", INFORMATION_MESSAGE);
        }
    }
    
    //returns totalShipsLeft, public because it's used in other classes
    public static int totalShipsLeft(){
        return numTwoWidthShips + numThreeWidthShips + numFourWidthShips + numFiveWidthShips;
    }
    
    //checks to see if userInput is valid
    private boolean isValid(int w, int r, int c, int d) {
        for(int i = 0; i < w; i++){
            if(d == NORTH){
                if(r - i < 0 || BattleshipGUI.playerArray[r-i][c].getBackground() == BattleshipGUI.battleship){
                    return false;
                }
            }
            else if (d == SOUTH){
                if(r + i > 9 || BattleshipGUI.playerArray[r+i][c].getBackground() == BattleshipGUI.battleship){
                    return false;
                }
            }
            else if (d == EAST){
                if(c + i > 9 || BattleshipGUI.playerArray[r][c+i].getBackground() == BattleshipGUI.battleship){
                    return false;
                }
            }
            else if (d == WEST){
                if(c - i < 0 || BattleshipGUI.playerArray[r][c-i].getBackground() == BattleshipGUI.battleship){
                    return false;
                }            
            }
        }
        
        if(w == 2 && numTwoWidthShips == 0){
            return false;
        }
        else if(w == 3 && numThreeWidthShips == 0){
            return false;
        }
        else if(w == 4 && numFourWidthShips == 0){
            return false;
        }
        else if (w == 5 && numFiveWidthShips == 0){
            return false;
        }
        return true;
    }
    
}
