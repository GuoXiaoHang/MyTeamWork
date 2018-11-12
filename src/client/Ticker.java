package client;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

public class Ticker implements Runnable{
	ActionListener al;
	private boolean isTicking;
	Thread t;
	int delay;
	public Ticker(int i, ActionListener actionlistener){
		al = actionlistener;
		delay = i;
		t = new Thread(this);
		t.start();
		isTicking = false;
	}

	public Ticker(int i){
		delay = i;
		t = new Thread(this);
		t.start();
		isTicking = false;
	}

	public boolean isRunning(){
		return isTicking;
	}

	public void start(){
		isTicking = true;
	}

	public void stop(){
		isTicking = false;
	}

	public void setDelay(int i){
		delay = i;
	}

	public int getDelay(){
		return delay;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}

