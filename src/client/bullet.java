package client;
import java.awt.*;

public class bullet implements Actor{
	public int xPos;
	public int yPos;
	public ClientModel gameModel;
	public int direction;
	public String Type = "bullet";

	public bullet(int xPos, int yPos,  ClientModel gameModel, int direction){
		this.xPos = xPos;
		this.yPos = yPos;
		this.gameModel = gameModel;
		this.direction = direction;
	}

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

