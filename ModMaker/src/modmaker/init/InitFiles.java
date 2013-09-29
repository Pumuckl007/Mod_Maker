package modmaker.init;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SpringLayout;


public class InitFiles extends JFrame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5516752214838397866L;
	public JProgressBar progressBar;
	public JLabel label;
	public SpringLayout manager;
	public boolean done = false;
	public InitFiles(){
		this.manager = new SpringLayout();
		this.setLayout(manager);
		this.setSize(600,200);
		this.addGui();
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	private void addGui(){
		this.progressBar = new JProgressBar();
		this.progressBar.setMinimum(0);
		this.progressBar.setMaximum(1000);
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
	@Override
	public void run() {
		this.setVisible(true);
		while(!done){
			
		}
		this.dispose();
	}
}
