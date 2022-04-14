public class Battleship {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //runs the GUI
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BattleshipGUI.createAndShowGUI();
            }
        });
    }
    
}
