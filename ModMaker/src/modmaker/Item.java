package modmaker;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Item {
	public ArrayList<Recipy> recipies = new ArrayList<Recipy>();
	private String name;
	private File image;
	private Integer id = 12345;
	private Integer metadat = 0;
	public Item(String name){
		this.name = name;
		this.image = new File("resources/textures/Tea-Bag.JPEG");
	}
	public String[] getItemForTable(){
		return new String[]{"Item", name, this.id.toString(), "Edit", "Delete"};
	}
	public Integer getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	public Integer getMetadat() {
		return metadat;
	}
	public void setMetadat(int metadat) {
		this.metadat = metadat;
	}
	public void setImage(String file){
		this.image = new File(file);
	}
	public void setImageFile(File file){
		this.image = file;
	}
	public URL getImage(){
		try {
			return image.toURI().toURL();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
