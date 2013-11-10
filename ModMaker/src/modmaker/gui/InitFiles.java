package modmaker.gui;

import java.util.concurrent.atomic.AtomicBoolean;



public class InitFiles implements Runnable {
	public AtomicBoolean done = new AtomicBoolean(false);
	public static final int lenght = 1000;
	public InitFilesWindow window = new InitFilesWindow();
	public void setProgress(int progress, String lable){
		window.setProgress(progress, lable);
	}
	public void setProgressBarVisible(boolean visible){
		window.setProgressBarVisible(visible);
	}
	public void setDimentions(int x , int y){
		window.setSize(x, y);
		window.setLocationRelativeTo(null);
	}
	@Override
	public void run() {
		Thread thread = new Thread(window);
		thread.start();
		while(!done.get()){
		}
		window.done.set(true);
	}
}
