package modmaker.gui;

import java.awt.Canvas;
import java.awt.Image;
import java.awt.Point;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;

import modmaker.Mod;

import org.jdesktop.swingx.JXList;

public class NewRecipy extends JDialog implements ActionListener, DragSourceListener, DragGestureListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8230403827129305296L;
	private DialogNewRecipy recipy;
	public RecipyButton recipySlot1,recipySlot2,recipySlot3,recipySlot4,recipySlot5,recipySlot6,recipySlot7,recipySlot8,recipySlot9;
	public ItemTableModle recipies;
	public DragSource ds;
	public JXList items;
	public StringSelection transferable;
	public DropTarget slot1,slot2,slot3,slot4,slot5,slot6,slot7,slot8,slot9;
	private JPanel panel;
	public Canvas c;
	public NewRecipy(JFrame parent, String title, DialogNewRecipy recipy) {
		super(parent, title, true);
		Point p = parent.getLocation(); 
		setLocation(p.x,p.y);
		this.setSize(parent.getSize());
		this.recipy = recipy;
		this.addGui();
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}
	private void addGui(){
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		JButton done = new JButton("Done");
		done.addActionListener(this);
		this.add(done);
		layout.putConstraint(SpringLayout.SOUTH, done,-20,SpringLayout.SOUTH, this.getContentPane());
		layout.putConstraint(SpringLayout.EAST, done,-20,SpringLayout.EAST, this.getContentPane());
		this.panel = new JPanel();
		layout.putConstraint(SpringLayout.SOUTH, panel,0,SpringLayout.SOUTH, this.getContentPane());
		layout.putConstraint(SpringLayout.EAST, panel,0,SpringLayout.HORIZONTAL_CENTER, this.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, panel,0,SpringLayout.NORTH, this.getContentPane());
		layout.putConstraint(SpringLayout.WEST, panel,0,SpringLayout.WEST, this.getContentPane());
		JScrollPane items = this.drawTable();
		this.add(items);
		layout.putConstraint(SpringLayout.SOUTH, items,-20,SpringLayout.NORTH, done);
		layout.putConstraint(SpringLayout.WEST, items,20,SpringLayout.HORIZONTAL_CENTER, this.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, items,20,SpringLayout.NORTH, this.getContentPane());
		layout.putConstraint(SpringLayout.EAST, items,-20,SpringLayout.EAST, this.getContentPane());
		this.setButtonStuff(layout);
		this.add(c = new Canvas());
		layout.putConstraint(SpringLayout.WEST, c,0,SpringLayout.WEST, this.getContentPane());
		layout.putConstraint(SpringLayout.WEST, c,58,SpringLayout.EAST, this.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, c,58,SpringLayout.SOUTH, this.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, c,0,SpringLayout.NORTH, this.getContentPane());

	}
	public JScrollPane drawTable(){
		ds = new DragSource();
		String[] itemNames = new String[Mod.vannilaItems.size()];
		int i = 0;
		for(String name : Mod.vannilaItems){
			itemNames[i] = name;
			i++;
		}
		items = new JXList(itemNames);
		items.setAutoCreateRowSorter(true);
		items.toggleSortOrder();
		items.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ds.createDefaultDragGestureRecognizer(items, DnDConstants.ACTION_COPY, this);
		JScrollPane finished = new JScrollPane(items);
		return finished;
	}
	public void actionPerformed(ActionEvent e) {
		this.recipy.done = true;
		this.recipy.recipy.recipy = this.recipySlot1.getItem() + "," + this.recipySlot2.getItem() + "," + this.recipySlot3.getItem() + "," +
		this.recipySlot4.getItem() + "," + this.recipySlot5.getItem() + "," + this.recipySlot6.getItem() + "," + this.recipySlot7.getItem() + "," +
		this.recipySlot8.getItem() + "," + this.recipySlot9.getItem();
		setVisible(false); 
		dispose(); 
	}
	private void setButtonStuff(SpringLayout layout){
		recipySlot5 = new RecipyButton();
		slot5 = new DropTarget(recipySlot5, new DebugDropListener(recipySlot5));
		recipySlot5.addActionListener(new RecipyActionListiner(recipySlot5));
		this.add(recipySlot5);
		layout.putConstraint(SpringLayout.SOUTH, recipySlot5,30,SpringLayout.VERTICAL_CENTER, this.getContentPane());
		layout.putConstraint(SpringLayout.WEST, recipySlot5,-30,SpringLayout.HORIZONTAL_CENTER, this.panel);
		layout.putConstraint(SpringLayout.NORTH, recipySlot5,-30,SpringLayout.VERTICAL_CENTER, this.getContentPane());
		layout.putConstraint(SpringLayout.EAST, recipySlot5,60,SpringLayout.WEST, recipySlot5);
		recipySlot4 = new RecipyButton();
		slot4 = new DropTarget(recipySlot4, new DebugDropListener(recipySlot4));
		recipySlot4.addActionListener(new RecipyActionListiner(recipySlot4));
		this.add(recipySlot4);
		layout.putConstraint(SpringLayout.SOUTH, recipySlot4,0,SpringLayout.SOUTH, recipySlot5);
		layout.putConstraint(SpringLayout.WEST, recipySlot4,-80,SpringLayout.WEST, recipySlot5);
		layout.putConstraint(SpringLayout.NORTH, recipySlot4,0,SpringLayout.NORTH, recipySlot5);
		layout.putConstraint(SpringLayout.EAST, recipySlot4,60,SpringLayout.WEST, recipySlot4);
		recipySlot1 = new RecipyButton();
		slot1 = new DropTarget(recipySlot1, new DebugDropListener(recipySlot1));
		recipySlot1.addActionListener(new RecipyActionListiner(recipySlot1));
		this.add(recipySlot1);
		layout.putConstraint(SpringLayout.SOUTH, recipySlot1,-20,SpringLayout.NORTH, recipySlot4);
		layout.putConstraint(SpringLayout.WEST, recipySlot1,0,SpringLayout.WEST, recipySlot4);
		layout.putConstraint(SpringLayout.NORTH, recipySlot1,-60,SpringLayout.SOUTH, recipySlot1);
		layout.putConstraint(SpringLayout.EAST, recipySlot1,0,SpringLayout.EAST, recipySlot4);
		recipySlot2 = new RecipyButton();
		slot2 = new DropTarget(recipySlot2, new DebugDropListener(recipySlot2));
		recipySlot2.addActionListener(new RecipyActionListiner(recipySlot2));
		this.add(recipySlot2);
		layout.putConstraint(SpringLayout.SOUTH, recipySlot2,0,SpringLayout.SOUTH, recipySlot1);
		layout.putConstraint(SpringLayout.WEST, recipySlot2,20,SpringLayout.EAST, recipySlot1);
		layout.putConstraint(SpringLayout.NORTH, recipySlot2,0,SpringLayout.NORTH, recipySlot1);
		layout.putConstraint(SpringLayout.EAST, recipySlot2,60,SpringLayout.WEST, recipySlot2);
		recipySlot3 = new RecipyButton();
		slot3 = new DropTarget(recipySlot3, new DebugDropListener(recipySlot3));
		recipySlot3.addActionListener(new RecipyActionListiner(recipySlot3));
		this.add(recipySlot3);
		layout.putConstraint(SpringLayout.SOUTH, recipySlot3,0,SpringLayout.SOUTH, recipySlot2);
		layout.putConstraint(SpringLayout.WEST, recipySlot3,20,SpringLayout.EAST, recipySlot2);
		layout.putConstraint(SpringLayout.NORTH, recipySlot3,0,SpringLayout.NORTH, recipySlot2);
		layout.putConstraint(SpringLayout.EAST, recipySlot3,60,SpringLayout.WEST, recipySlot3);
		recipySlot7 = new RecipyButton();
		slot7 = new DropTarget(recipySlot7, new DebugDropListener(recipySlot7));
		recipySlot7.addActionListener(new RecipyActionListiner(recipySlot7));
		this.add(recipySlot7);
		layout.putConstraint(SpringLayout.NORTH, recipySlot7,20,SpringLayout.SOUTH, recipySlot4);
		layout.putConstraint(SpringLayout.WEST, recipySlot7,0,SpringLayout.WEST, recipySlot4);
		layout.putConstraint(SpringLayout.SOUTH, recipySlot7,60,SpringLayout.NORTH, recipySlot7);
		layout.putConstraint(SpringLayout.EAST, recipySlot7,0,SpringLayout.EAST, recipySlot4);
		recipySlot8 = new RecipyButton();
		slot8 = new DropTarget(recipySlot8, new DebugDropListener(recipySlot8));
		recipySlot8.addActionListener(new RecipyActionListiner(recipySlot8));
		this.add(recipySlot8);
		layout.putConstraint(SpringLayout.SOUTH, recipySlot8,0,SpringLayout.SOUTH, recipySlot7);
		layout.putConstraint(SpringLayout.WEST, recipySlot8,20,SpringLayout.EAST, recipySlot7);
		layout.putConstraint(SpringLayout.NORTH, recipySlot8,0,SpringLayout.NORTH, recipySlot7);
		layout.putConstraint(SpringLayout.EAST, recipySlot8,60,SpringLayout.WEST, recipySlot8);
		recipySlot9 = new RecipyButton();
		slot9 = new DropTarget(recipySlot9, new DebugDropListener(recipySlot9));
		recipySlot9.addActionListener(new RecipyActionListiner(recipySlot9));
		this.add(recipySlot9);
		layout.putConstraint(SpringLayout.SOUTH, recipySlot9,0,SpringLayout.SOUTH, recipySlot8);
		layout.putConstraint(SpringLayout.WEST, recipySlot9,20,SpringLayout.EAST, recipySlot8);
		layout.putConstraint(SpringLayout.NORTH, recipySlot9,0,SpringLayout.NORTH, recipySlot8);
		layout.putConstraint(SpringLayout.EAST, recipySlot9,60,SpringLayout.WEST, recipySlot9);
		recipySlot6 = new RecipyButton();
		slot6 = new DropTarget(recipySlot6, new DebugDropListener(recipySlot6));
		recipySlot6.addActionListener(new RecipyActionListiner(recipySlot6));
		this.add(recipySlot6);
		layout.putConstraint(SpringLayout.SOUTH, recipySlot6,0,SpringLayout.SOUTH, recipySlot5);
		layout.putConstraint(SpringLayout.WEST, recipySlot6,20,SpringLayout.EAST, recipySlot5);
		layout.putConstraint(SpringLayout.NORTH, recipySlot6,0,SpringLayout.NORTH, recipySlot5);
		layout.putConstraint(SpringLayout.EAST, recipySlot6,60,SpringLayout.WEST, recipySlot6);
	}
	private class RecipyActionListiner implements ActionListener{
		private RecipyButton button;
		public RecipyActionListiner(RecipyButton button){
			this.button = button;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			this.button.setIcon(null);
			this.button.setItem(null);
			this.button.setToolTipText(null);
		}
		
	}
	@Override
	public void dragGestureRecognized(DragGestureEvent dge) {
		transferable = new StringSelection((String) items.getSelectedValue());
		ds.startDrag(dge, DragSource.DefaultCopyDrop, transferable, this);
	}
	private class DebugDropListener implements DropTargetListener {
		private RecipyButton button;
		public DebugDropListener(RecipyButton button){
			this.button = button;
		}
		@Override
		public void dragEnter(DropTargetDragEvent dtde) {
			
		}

		@Override
		public void dragExit(DropTargetEvent dte) {
			
		}

		@Override
		public void dragOver(DropTargetDragEvent dtde) {
			
		}

		@Override
		public void drop(DropTargetDropEvent dtde) {
			try {
				ImageIcon icon = Mod.vannilaItemLookUp.get(dtde.getTransferable().getTransferData(DataFlavor.stringFlavor)).getImageIcon(58,58);
				this.button.setIcon(new ImageIcon(icon.getImage().getScaledInstance((int)58, (int)58, Image.SCALE_DEFAULT)));
				this.button.setItem(Mod.vannilaItemLookUp.get(dtde.getTransferable().getTransferData(DataFlavor.stringFlavor)).getName());
				this.button.setToolTipText(Mod.vannilaItemLookUp.get(dtde.getTransferable().getTransferData(DataFlavor.stringFlavor)).getName() + " (" +
						Mod.vannilaItemLookUp.get(dtde.getTransferable().getTransferData(DataFlavor.stringFlavor)).getId().toString() + ":" + 
						Mod.vannilaItemLookUp.get(dtde.getTransferable().getTransferData(DataFlavor.stringFlavor)).getMetadat().toString() + ")");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		@Override
		public void dropActionChanged(DropTargetDragEvent dtde) {
			
		}
		
	}
	@Override
	public void dragDropEnd(DragSourceDropEvent dsde) {
		
	}
	@Override
	public void dragEnter(DragSourceDragEvent dsde) {
		
	}
	@Override
	public void dragExit(DragSourceEvent dse) {
		
	}
	@Override
	public void dragOver(DragSourceDragEvent dsde) {
		
	}
	@Override
	public void dropActionChanged(DragSourceDragEvent dsde) {
		
	}
}
