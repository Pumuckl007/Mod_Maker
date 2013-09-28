package modmaker.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import modmaker.Item;

public class RemoveButton extends DefaultCellEditor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5515760552009652079L;

	protected JButton button;

	private String label;

	private boolean isPushed;

	private int row;
	private Item item;
	private ItemTableModle model;

	public RemoveButton(JCheckBox checkBox) {
		super(checkBox);
		button = new JButton();
		button.setOpaque(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
			}
		});
	}

	public Component getTableCellEditorComponent(JTable table, Object value,
			boolean isSelected, int row, int column) {
		TableModel model = table.getModel();
		if(model instanceof ItemTableModle){
			this.item = ((ItemTableModle) model).getItem();
			this.model = (ItemTableModle) model;
		}
		if (isSelected) {
			button.setForeground(table.getSelectionForeground());
			button.setBackground(table.getSelectionBackground());
		} else {
			button.setForeground(table.getForeground());
			button.setBackground(table.getBackground());
		}
		label = (value == null) ? "" : value.toString();
		button.setText(label);
		isPushed = true;
		this.row = row;
		return button;
	}

	public Object getCellEditorValue() {
		if (isPushed) {
			this.item.recipies.remove(row);
			this.model.removeRow(row);
		}
		isPushed = false;
		return new String(label);
	}

	public boolean stopCellEditing() {
		isPushed = false;
		return super.stopCellEditing();
	}

	protected void fireEditingStopped() {
		try{
			super.fireEditingStopped();
		}catch(Exception e){if(e instanceof java.lang.IndexOutOfBoundsException){}else{ e.printStackTrace();}}
	}
}

