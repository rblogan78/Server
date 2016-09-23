public class BMIRange{
	private String lower;
	private String upper;
	private String name;
	private boolean normal;

	public BMIRange(){
		lower = "";
		upper = "";
		name = "default";
		noraml = false;
	}

	public BMIRange(String low, String up, String n, boolean norm){
		lower = low;
		upper = up;
		name = n;
		normal = norm;
	}

	public void setLower(String l){
		lower = l;
	}

	public void setUpper(String u){
		upper = u;
	}

	public void setName(String n){
		name = n;
	}

	public setNorm(boolean norml){
		normal = norml;
	}

	public String getLower(){
		return lower;
	} 

	public String getUpper(){
		return upper;
	}

	public String getName(){
		return name;
	}

	public boolean getNorm(){
		return normal;
	}
}