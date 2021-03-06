package modmaker.gui;

import javax.swing.table.DefaultTableModel;

import modmaker.Item;

public class ItemTableModle extends DefaultTableModel {

	private static final long serialVersionUID = -2782223919757645080L;
	protected Item item;
	public ItemTableModle(Item item){
		this.item = item;
	}
	public ItemTableModle(){
		this.item = null;
	}
	public Item getItem(){
		return this.item;
	}
	public boolean isCellEditable(int row, int column){ 
		if(this.getValueAt(row, column) instanceof String)
			return (this.getValueAt(row, column).equals("Edit") ||this.getValueAt(row, column).equals("Delete") ||this.getValueAt(row, column).equals("Remove"));
		else
			return true;
    }
	@Override
	public void setValueAt(Object aValue, int row, int column) {
		if(!(this.getRowCount() >= row) && row > 0)
		super.setValueAt(aValue, row, column);
	}
	


}
