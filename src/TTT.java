import java.awt.Graphics2D;
import java.awt.event.MouseEvent;


public class TTT {

	public TTT(Game game,int size)
	{
		this.size = size;
        board = new String[size][size];
        
        for (int i = 0; i< size; ++i)
        	for (int j = 0; j < size; ++j)
        		board[i][j] = "";	
        this.game = game;
	}
	
	public void setPosition(int x,int y)
	{
		X0 = x;
		Y0 = y;
		side = (game.WIDTH-2*x)/size;
		System.out.println("side="+side);
	}
	public void paint(Graphics2D g) {
		for (int i = 0; i< size; ++i)
		{
        	for (int j = 0; j < size; ++j)
        	{
        		int x = X0 + i*side;
        		int y = Y0 + j*side;
        		g.drawRect(x, y, side, side);
        		if (board[i][j].equals("B"))
        		  g.fillOval(x+SPACE, y+SPACE, side-2*SPACE, side-2*SPACE);
        		else if (board[i][j].equals("W"))
        		  g.drawOval(x+SPACE, y+SPACE, side-2*SPACE, side-2*SPACE);
        	}
		}
	}
	
	public boolean mouseReleased(MouseEvent e,int player) {
		int x = e.getX()-X0;
		int y = e.getY()-Y0;
		System.out.println("X="+x+" and y="+y);
		int i,j;
		if (x<0 || y< 0)
			return false;
		
		if (x>(side*size) || y>(side*size))
			return false;
		
		i = x/side;
		j = y/side;
		
		if (board[i][j].equals(""))
		{
		  String mark = getMark(player);
		  board[i][j] = mark;
		  game.repaint();
		  return true;
		}
		return false;
    }
	
	public String getMark(int player)
	{
		if (player == 1)
			return "B";
		else
			return "W";
	}
	
	public boolean isFull()
	{
		for (int i=0;i<size;++i)
		{
			for (int j=0;j<size;++j)
				if (board[i][j].isEmpty())
					return false;
		}
		return true;
	}
	
	public void clearAll()
	{
	for (int i = 0; i < size; ++i) {
		for (int j = 0; j < size; ++j) {
			board[i][j] = "";	
				        }
				        
				}
	
	}

	public boolean checkWin(String player)
	{
		// check column
		for (int i=0;i<size;++i)
		{
			int j = 0;
			for (j=0;j<size;++j)
			{
				if (board[i][j]!=player)
					break;
			}
			if (j==size)
				return true;
		}
		
		//check row
		for (int i=0;i<size;++i)
		{
			int j = 0;
			for (j=0;j<size;++j)
			{
				if (board[j][i]!=player)
					break;
			}
			if (j==size)
				return true;
		}
		
		// check diagonal right
		int i=0;
		for (;i<size;++i)
		{
			if (board[i][i]!=player)
				break;
		}
		if (i==size)
			return true;
		
		// check diagonal left
		i = 0;
		int j = size-1;
		for (;i<size;++i,--j)
		{
			if (board[i][j]!=player)
				break;
		}
		if (i==size)
			return true;
		return false;	
	}
	
	private int X0;
    private int Y0;
	private int side;
	private int size;
    private String[][] board;
    private Game game;
    private final int SPACE=10;  
}

