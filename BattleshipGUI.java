public class BattleshipGUI extends JFrame{
    //creates GridLayout for display
    GridLayout playerGrid = new GridLayout(10,10);
    GridLayout opponentGrid = new GridLayout(10,10);
    
    //large amounts of public static for easy access to things from different arrays (I know it's not the safest)
    static JButton[][] playerArray = new JButton[10][10];
    static JButton[][] opponentArray = new JButton[10][10];
    static JButton[][] hiddenComputerArray = new JButton[10][10];
    static Color water = Color.BLUE;
    static Color battleship = Color.GRAY;
    static Color hit = Color.RED;
    static Color miss = Color.WHITE;
    static int difficultyMod;
    
    //creates JFrame
    public BattleshipGUI(String name){
        super(name);
        setResizable(false);
    }
    
    
    public void addComponentsToPane(final Container pane) {
        //creates panel
        final JPanel compsToGUI = new JPanel();
        
        //sets playerGrid and playerArray up
        compsToGUI.setLayout(playerGrid);
        
        for(int r = 0; r < 10; r++){
            for(int c = 0; c < 10; c++){
                playerArray[r][c] = new JButton(" ");
                playerArray[r][c].setBackground(water);
                compsToGUI.add(playerArray[r][c]);
            }
        }
        
        //creates a different panel adding opponentGrid,  sets opponentArray and HitMechanics up 
        final JPanel oppCompsToGUI = new JPanel();
        oppCompsToGUI.setLayout(opponentGrid);
        HitMechanics hitMechanics = new HitMechanics();
        
        for(int r = 0; r < 10; r++){
            for(int c = 0; c < 10; c++){
                opponentArray[r][c] = new JButton(" ");
                opponentArray[r][c].setBackground(water);
                opponentArray[r][c].addActionListener(hitMechanics);
                oppCompsToGUI.add(opponentArray[r][c]);
            }
        }
        
        //creates the hiddenComputerArray and sets it up
        for(int r = 0; r < 10; r++){
            for(int c = 0; c < 10; c++){
                hiddenComputerArray[r][c] = new JButton(" ");
                hiddenComputerArray[r][c].setBackground(water);
            }
        }
        //adds computer ships
        AddingComputerShips.actionPerformed();
        
        //add basic features (adding ships for the player, a restart button)
        AddingShips addingShips = new AddingShips();
        JButton addShips = new JButton("Add Ships");
        addShips.addActionListener(addingShips);
        
        Restart restartAction = new Restart();
        JButton restart = new JButton("Restart");
        restart.addActionListener(restartAction);
        
        //adds buttons, grid and such to frame 
        pane.add(compsToGUI, BorderLayout.NORTH);
        pane.add(new JSeparator(), BorderLayout.CENTER);
        pane.add(oppCompsToGUI, BorderLayout.SOUTH);
        pane.add(addShips, BorderLayout.EAST);
        pane.add(restart, BorderLayout.WEST);
        
        //added a direction message
        JOptionPane.showMessageDialog(null, "Add Ships to Begin. Click on the opponent's tile you want to hit once finished. "
                + "Click again for your opponent to make a move. Once a player has sunk all of their enemies ships, they win.", 
                "Directions", INFORMATION_MESSAGE);
        
        //added a difficulty modifier
        String difficulty = JOptionPane.showInputDialog("Enter Difficulty (Easy, Medium, Hard)");
        if(difficulty.equalsIgnoreCase("easy")){
            difficultyMod = 7;
        }
        else if (difficulty.equalsIgnoreCase("medium")){
            difficultyMod = 6;
        }
        else{
            difficultyMod = 5;
        } 
        
    }
