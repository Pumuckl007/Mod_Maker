package modmaker;

public class Recipy {
	public String recipy;
	public String[] getStringForTable(){
		if(recipy == null){
		return new String[]{"Shaped","Wood,Wood,Wood Blank,Stick,Blank ,Blank,Stick,Blank", "Remove"};
		}
		else{
			return new String[]{"Shaped",recipy, "Remove"};
		}
	}
}
