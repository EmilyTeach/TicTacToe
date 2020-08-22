import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GameTester extends JFrame implements ActionListener {

	private Game game = new Game();
	public GameTester()
	{
		JMenuBar menuBar;
		JMenu menu,menu2;
		JMenuItem newGame,exitGame,name1Menu,name2Menu;

	    menuBar = new JMenuBar();
	    menu = new JMenu("Game");
	    menu.setMnemonic(KeyEvent.VK_G);
	    
	    newGame = new JMenuItem("New       ");
	    newGame.setAccelerator(KeyStroke.getKeyStroke(
	            KeyEvent.VK_N, ActionEvent.ALT_MASK));
	    exitGame = new JMenuItem("Exit");
	    
	    newGame.addActionListener(this);
	    exitGame.addActionListener(this);
	    
	    menu.add(newGame);
	    menu.add(exitGame);
	    
	    menuBar.add(menu);
	    
	    menu2 = new JMenu("Setting");
	    menu2.setMnemonic(KeyEvent.VK_S);
	    
	    name1Menu = new JMenuItem("Set Name for Player 1");
	    name2Menu = new JMenuItem("Set Name for Player 2");
	    name1Menu.addActionListener(this);
	    name2Menu.addActionListener(this);
	    menu2.add(name1Menu);
	    menu2.add(name2Menu);
	    menuBar.add(menu2);
	    
	    setJMenuBar(menuBar);
	    
		//Game game = new Game();
		add(game);
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("command="+e.getActionCommand());
    	String cmd = e.getActionCommand();
    	if (cmd.equals("New       "))
    	{
    		int restart = JOptionPane.showConfirmDialog(this,"Are you sure to start a new game?","Game Over",JOptionPane.YES_NO_OPTION);
    		if (restart == JOptionPane.YES_OPTION)
    		  game.restart();
    	}
    	else if (cmd.equals("Exit"))
    	{
    		int exit = JOptionPane.showConfirmDialog(this,"Are you sure to exit?","Game Over",JOptionPane.YES_NO_OPTION);
    		if (exit == JOptionPane.YES_OPTION)
    		  System.exit(ABORT);
    	}
    	else if (cmd.contains("Name"))
    	{
    		int player = Integer.parseInt(cmd.substring(cmd.length()-1));
    		String name=JOptionPane.showInputDialog(this,"Enter Name");
    		if (name!=null && !name.isEmpty())
    		  game.namePlayer(player-1, name);
    	}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameTester window = new GameTester();
		window.setTitle("Tic Tac Toe");
		window.setSize(Game.WIDTH,Game.HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		window.setVisible(true);
	}

}
