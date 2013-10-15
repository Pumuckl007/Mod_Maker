package modmaker.gui;

import javax.swing.JDialog;

public class SetDialogShown implements Runnable {
	public JDialog dialog;
	public SetDialogShown(JDialog dialog){
		this.dialog = dialog;
	}
	@Override
	public void run() {
		this.dialog.setVisible(true);
	}

}
