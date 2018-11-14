package client;
import java.awt.*;

public class wall implements Actor{
	public final String Type = "wall";
	public int xPos;
	public int yPos;
	public boolean[] shape;
	public ClientModel gameModel;

	public int getxPos(){
		return xPos;
	}

	public int getyPos(){
		return yPos;
	}

	public String getType(){
		return Type;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}
}