package modmaker.gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTable;

import modmaker.Start;

public class ButtonEditor extends DefaultCellEditor {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6914294806953729146L;

	protected JButton button;

	private String label;

	private boolean isPushed;

	private int row;

	public ButtonEditor(JCheckBox checkBox) {
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
			if(this.label.equals("Delete")){
				if(Start.gui.items.getRowCount() >= this.row){
					Start.main.mod.items.remove(this.row);
					Start.gui.items.removeRow(this.row);
				}
			}
			else{
				new DialogEditItem().openGui(row);;
			}
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

