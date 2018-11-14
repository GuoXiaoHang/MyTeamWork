package server;
import java.net.*;
import java.io.*;
import java.awt.event.*;
import java.awt.*;

public class ClientModel implements ActionListener{
	public ClientView view;

	//连接变量
	public Socket clientSocket;
	public PrintWriter out;
	public BufferedReader in;
	public String fromServer,  fromUser;
	public String serverIP;

	//客户端状态
	public boolean serverConnected;
	public boolean gameStarted;
	public boolean gamePaused;
	public boolean gameOver;
	public boolean serverVoteYes, serverVoteNo;
	public boolean clientVoteYes, clientVoteNo;
	public boolean pausePressed;

	//图像信息
	public String[] messageQueue;
	public int messageIndex;
	public String playerTypedMessage = "";


	//textures
	public Image[] textures;

	//实际的游戏运行在这个线程,而主线程听用户的输入
	public Ticker t;

	//游戏变量
	public static int gameFlow;
	public Actor[] drawingList;
	public boolean moveUp;
	public boolean moveDown;
	public boolean moveLeft;
	public boolean moveRight;
	public boolean fire;

	public void connectServer(){
		addMessage("正在连接主机");

		try{
		 	serverIP = view.IPfield.getText();
		 	InetAddress addr = InetAddress.getByName(serverIP);
			clientSocket = new Socket(addr, 9999);

			out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		}catch(Exception e){
			t.stop();
			System.out.println(e);
			addMessage("连接中出现错误， 请确认 1. 输入的IP是否正确,   2. 主机端已存在");
			return;
		}

		serverConnected = true;
		addMessage("已成功连接到主机，开始载入游戏");
		view.IPfield.setFocusable(false);
		view.IPfield.setEnabled(false);

		//加载游戏 texture
		textures = new Image[88];
		for(int i = 1; i < textures.length+1; i++)
			textures[i-1] = Toolkit.getDefaultToolkit().getImage("image\\" + i + ".jpg");


		drawingList = new Actor[400];

		gameStarted = true;
		view.messageField.setEnabled(true);
		addMessage("载入完毕，游戏开始了！");
	}



	//在屏幕上显示一条消息
	public void addMessage(String message){
		if(messageIndex < 8){
			messageQueue[messageIndex] = message;
			messageIndex++;
		}
		else{
			for(int  i = 0; i < 7; i++)
				messageQueue[i] = messageQueue[i+1];
			messageQueue[7] = message;
		}

	}

	//删除最早的消息在屏幕上
	public void removeMessage(){
		if(messageIndex == 0)
			return;

		messageIndex--;
		for(int  i = 0; i < messageIndex; i++)
			messageQueue[i] = messageQueue[i+1];
		messageQueue[messageIndex] = null;

	}

	//添加一个游戏对象(如坦克、子弹等)图纸清单
	public void addActor(Actor actor){
		for(int i = 0; i < drawingList.length; i ++ )
			if(drawingList[i] == null){
				drawingList[i] = actor;
				break;
			}
	}

	//删除一个游戏对象从图纸清单
	public void removeActor(Actor actor){
			for(int i = 0; i < drawingList.length; i ++ )
					if(drawingList[i] == actor){
						drawingList[i] = null;
						break;
			}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
