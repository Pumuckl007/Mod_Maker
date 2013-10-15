package modmaker.gui;



public class OpenModInfo {
	public void open(String title, boolean replace){
		new DialogModInfoGui(title,replace, this);
	}
}
