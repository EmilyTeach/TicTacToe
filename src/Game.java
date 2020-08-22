import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Game extends JPanel implements MouseListener{

	private int player = 0;
	private int[] scores;
	private String[] names;
	static public final int WIDTH = 400;
	static public final int HEIGHT = 500;
	static private final int SIZE = 4;
	private TTT board = new TTT(this,SIZE);
	
	public Game()
	{
		scores = new int[2];
		scores[0] = 0;
		scores[1] = 0;
		names = new String[2];
		names[0] = "Player 1";
		names[1] = "player 2"; 
		board.setPosition(35, 80);
		addMouseListener(this);
	}
	
	public void restart()
	{
		scores[0] = 0;
		scores[1] = 0;
		player = 0;
		board.clearAll();		
		repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		board.paint(g2d);

		
		//g2d.drawString("Player "+String.valueOf(getPlayer())+"   Score: "+ score1, 30, 30);
		if (board.getMark(0).equals("B"))
			g2d.fillOval(70,12,20,20);
		else
			g2d.drawOval(70, 12, 20, 20);
		if (board.getMark(1).equals("B"))
			g2d.fillOval(70,42,20,20);
		else
			g2d.drawOval(70, 42, 20, 20);
		g2d.setColor(Color.GRAY);
		g2d.setFont(new Font("Verdana", Font.BOLD, 20));
		g2d.drawString(names[0] +"  --  Score: "+ scores[0], 100, 30);
		g2d.drawString(names[1] +"  --  Score: "+ scores[1], 100, 60);
		g2d.setColor(Color.RED);
		if (player == 0)
			g2d.fillOval(50,15,10,10);
		else
			g2d.fillOval(50,45,10,10);
		
	}
	
	public void namePlayer(int player,String name)
	{
		names[player] = name;
		repaint();
	}
	public int getPlayer()
	{
		return player;
	}
	public void changePlayer()
	{
		if (player==1)
			player = 0;
		else
			player = 1;
	}
	public void mouseClicked(MouseEvent e) {
		
    }  
    public void mouseEntered(MouseEvent e) {
    	
    }  
    public void mouseExited(MouseEvent e) {
    	
    }  
    public void mousePressed(MouseEvent e) {
    	
    }  
    public void mouseReleased(MouseEvent e) {
    	if (board.mouseReleased(e,player)) 
    	{
    	  boolean over = false;
    	  if (board.checkWin(board.getMark(player)))
    	  {
    		over =true;
    		scores[player]++;
    	    JOptionPane.showMessageDialog(this,"Winner is player "+ names[player]+"!");
    	  }
    	  else if (board.isFull())
    	  {
    		over = true;
    		JOptionPane.showMessageDialog(this,"The board is full.");
    	  }
    	  if (over)
    	  {
  			board.clearAll();
  			repaint();
    	  }
    	  changePlayer();
    	}
    }  

}
