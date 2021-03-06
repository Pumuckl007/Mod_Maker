package modmaker.gui;

import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SpringLayout;


public class InitFilesWindow extends JFrame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5516752214838397866L;
	public JProgressBar progressBar;
	public JLabel label;
	public SpringLayout manager;
	public AtomicBoolean done = new AtomicBoolean(false);
	public InitFilesWindow(){
		this.manager = new SpringLayout();
		this.setLayout(manager);
		this.setSize(800,200);
		this.setLocationRelativeTo(null);
		this.addGui();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	private void addGui(){
		this.progressBar = new JProgressBar();
		this.progressBar.setMinimum(0);
		this.progressBar.setMaximum(InitFiles.lenght);
		this.progressBar.setVisible(false);
		this.add(progressBar);
		manager.putConstraint(SpringLayout.NORTH, this.progressBar, -30, SpringLayout.VERTICAL_CENTER, this.getContentPane());
		manager.putConstraint(SpringLayout.WEST, this.progressBar, 20, SpringLayout.WEST, this.getContentPane());
		manager.putConstraint(SpringLayout.SOUTH, this.progressBar, -10, SpringLayout.VERTICAL_CENTER, this.getContentPane());
		manager.putConstraint(SpringLayout.EAST, this.progressBar, -20, SpringLayout.EAST, this.getContentPane());
		this.label = new JLabel();
		this.label.setText("Initialzising");
		this.add(label);
		manager.putConstraint(SpringLayout.NORTH, this.label, 20, SpringLayout.SOUTH, this.progressBar);
		manager.putConstraint(SpringLayout.WEST, this.label, 20, SpringLayout.WEST, this.getContentPane());
	}
	public void setProgress(int progress, String lable){
		this.progressBar.setValue(progress);
		this.label.setText(lable);
	}
	public void setProgressBarVisible(boolean visible){
		this.progressBar.setVisible(visible);
	}
	@Override
	public void run() {
		Gui.stardardLookAndFeel(this);
		this.setTitle("ModMaker");
		this.setVisible(true);
		while(!done.get()){
		}
		this.dispose();
	}
}
