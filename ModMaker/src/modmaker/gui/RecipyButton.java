package modmaker.gui;

import javax.swing.JButton;

public class RecipyButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4717167659021584644L;
	private String item = null;
	public RecipyButton(){
		super("");
	}
	public String getItem() {
		if(item == null)
			return "Blank";
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}

}
