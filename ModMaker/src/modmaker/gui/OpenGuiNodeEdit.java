package modmaker.gui;

import javax.swing.JDialog;

public class OpenGuiNodeEdit extends JDialog{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8848896486440638751L;
	public static GuiNodeEdit opengui(JDialog frame){
		return new GuiNodeEdit(frame);
	}
}
