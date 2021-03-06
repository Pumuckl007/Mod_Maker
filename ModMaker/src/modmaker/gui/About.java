package modmaker.gui;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import modmaker.Main;
import modmaker.file.FileUtils;

public class About extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2355705990442516212L;
	private DialogAbout dialog;
	public About(JFrame parent, String title, DialogAbout dialog) {
		super(parent, title, true);
		this.dialog = dialog;
		Point p = parent.getLocation(); 
		setLocation(p.x,p.y);
		this.setSize(parent.getSize());
		this.addGui();
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setVisible(true);
	}

	private void addGui(){
		SpringLayout layout = new SpringLayout();
		this.setLayout(layout);
		JButton back = new JButton("Back");
		back.addActionListener(this);
		this.add(back);
		layout.putConstraint(SpringLayout.SOUTH, back,-20,SpringLayout.SOUTH, this.getContentPane());
		layout.putConstraint(SpringLayout.EAST, back,-20,SpringLayout.EAST, this.getContentPane());
		JTextArea aboutText = new JTextArea();
		aboutText.setText(this.getText());
		aboutText.setFocusable(false);
		aboutText.setWrapStyleWord(true);
		JScrollPane about = new JScrollPane(aboutText);
		about.setAutoscrolls(false);
		this.add(about);
		layout.putConstraint(SpringLayout.NORTH, about,20,SpringLayout.NORTH, this.getContentPane());
		layout.putConstraint(SpringLayout.EAST, about,-20,SpringLayout.EAST, this.getContentPane());
		layout.putConstraint(SpringLayout.SOUTH, about,-20,SpringLayout.NORTH, back);
		layout.putConstraint(SpringLayout.WEST, about,20,SpringLayout.WEST, this.getContentPane());
	}
	private String getText(){
		StringBuilder builder = new StringBuilder();
		builder.append("Credits also found at " + FileUtils.getWorkingDirectory().getAbsolutePath() + ": \nModMaker By Pumuckl007\nSwingX by Free Software Foundation"
				+ "\nLWJGL by Lightweight Java Game Library Project\nSlick Util by Slick2D\nGson by Google"
				+ "\nMinecraftForge by:\n\n");
		try{
			BufferedReader about = new BufferedReader(new FileReader(FileUtils.getWorkingDirectory().getAbsolutePath() + "/MinecraftForge/forge/MinecraftForge-Credits.txt"));
			String line;
			while((line = about.readLine()) != null){
				builder.append(line);
				builder.append("\n");
			}
			about.close();
		}catch(Exception e){e.printStackTrace();}
		if(Main.hasMcpPremistion)
			builder.append("\nMinecraft Coder Pack by MCP Team\n================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================");
		else{
			builder.append("\n================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================================");
		}
		builder.append("\n\n\n\nModMaker Licence: \n");
		try{
			BufferedReader about = new BufferedReader(new FileReader(FileUtils.getWorkingDirectory().getAbsolutePath() + "/ModMaker_lisence.txt"));
			String line;
			while((line = about.readLine()) != null){
				builder.append(line);
				builder.append("\n");
			}
			about.close();
		}catch(Exception e){e.printStackTrace();}
		builder.append("\n\n\n\nSwingX Licence:\n");
		try{
			BufferedReader about = new BufferedReader(new FileReader(FileUtils.getWorkingDirectory().getAbsolutePath() + "/SwingX_lisence.txt"));
			String line;
			while((line = about.readLine()) != null){
				builder.append(line);
				builder.append("\n");
			}
			about.close();
		}catch(Exception e){e.printStackTrace();}
		builder.append("\n\n\n\nLWJGL Licence:\n");
		try{
			BufferedReader about = new BufferedReader(new FileReader(FileUtils.getWorkingDirectory().getAbsolutePath() + "/LWJGL_lisence.txt"));
			String line;
			while((line = about.readLine()) != null){
				builder.append(line);
				builder.append("\n");
			}
			about.close();
		}catch(Exception e){e.printStackTrace();}
		builder.append("\n\n\n\nSlick Util Licence:\n");
		try{
			BufferedReader about = new BufferedReader(new FileReader(FileUtils.getWorkingDirectory().getAbsolutePath() + "/SlickUtil_lisence.txt"));
			String line;
			while((line = about.readLine()) != null){
				builder.append(line);
				builder.append("\n");
			}
			about.close();
		}catch(Exception e){e.printStackTrace();}
		builder.append("\n\n\n\nMinecraft Forge Licence:\n");
		try{
			BufferedReader about = new BufferedReader(new FileReader(FileUtils.getWorkingDirectory().getAbsolutePath() + "/MinecraftForge/forge/MinecraftForge-License.txt"));
			String line;
			while((line = about.readLine()) != null){
				builder.append(line);
				builder.append("\n");
			}
			about.close();
		}catch(Exception e){e.printStackTrace();}
		if(Main.hasMcpPremistion){
			builder.append("\n\n\n\nMinecraft Coder Pack Licence:\n");
			try{
				BufferedReader about = new BufferedReader(new FileReader(FileUtils.getWorkingDirectory().getAbsolutePath() + "/MinecraftForge/forge/mcp/LICENSE.txt"));
				String line;
				while((line = about.readLine()) != null){
					builder.append(line);
					builder.append("\n");
				}
				about.close();
			}catch(Exception e){e.printStackTrace();}
		}
		builder.append("\n\n\n\nGson Licence:\n");
		try{
			BufferedReader about = new BufferedReader(new FileReader(FileUtils.getWorkingDirectory().getAbsolutePath() + "/Gson_licence.txt"));
			String line;
			while((line = about.readLine()) != null){
				builder.append(line);
				builder.append("\n");
			}
			about.close();
		}catch(Exception e){e.printStackTrace();}
		return builder.toString();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		this.dialog.done = true;
		this.setVisible(false);
		this.dispose();
	}
}
