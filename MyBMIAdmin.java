import java.util.*;

public class MyBMIAdmin{
	private LinkedList<BMIRange> ranges = new LinkedList<BMIRange>();
	private String USERNAME = "admin";
	private String PASSWORD = "bodymass";
	private int count;

	public MyBMIAdmin(){
		ranges.add(new BMIRange("0.00", "18.49", "UNDERWEIGHT", false));
		ranges.add(new BMIRange("18.50", "24.99", "NORMAL RANGE", true));
		ranges.add(new BMIRange("25.00", "29.99", "OVERWEIGHT", false));
		ranges.add(new BMIRange("30.00", "100.00", "OBESE", false));
		count = 0;
	}
	
	public boolean addRange(String user, String pwd, String lower, String upper, String name, boolean normal){
		boolean success = true;
		//validate the username and password
		if(!this.validate(user, pwd)){
			//message to user?
			success = false;
		}
		//validate that the name does not already exist
		if(this.findName(name)<0){
			//messge to user?
			success = false;
		}
		//validate the upper/lower bounds do not overlap with another defined range - return false if fail
		
		//put the range into the hashmap
		if(success){
			ranges.add(new BMIRange(lower, upper, name, normal));
		}
		this.incCount();
		return success;
	}

	public boolean deleteRange(String user, String pwd, String name){
		boolean success = true;
		//validate the username and password - else return false
		if(!this.validate(user, pwd)){
			success = false;
		}
		//check that the name exists - else return false
		int ind = this.findName(name);
		if(ind>=0){
			ranges.remove(ind);
			//messge to user?
		}else{
			success = false;
		}
		this.incCount();
		return success;
	}

	public boolean setName(String user, String pwd, String oldName, String newName){
		boolean success = true;
		//validate the username and password - else return false
		if(!this.validate(user, pwd)){
			success = false;
		}
		int ind = this.findName(oldName);
		if(ind<0){
			//messge to user?
			success = false;
		}else{
			ranges.get(i).setName(newName);
		}
		this.incCount();
		return success;
	}

	public int callCount(String user, String pwd){
		this.incCount();
		if(!this.validate(user, pwd)){
			return -1;
		}else{
			return count;
		}
	}

	private boolean validate(String usr, String pass){
		boolean valid = false;
		if(usr.equals(DEFAULT_USERNAME) && pass.equals(DEFAULT_PASSWORD)){
			valid = true;
		}

		return valid;
	}

	public void incCount(){
		count++;
	}

	public String findRange(double bmi){
		BMIRange temp = null;
		String class = "";
		boolean found = false;
		for (int i = 0; i < ranges.size(); i++) {
			temp = ranges.get(i);
			double low = Double.parseDouble(temp.getLower());
			double high = Double.parseDouble(temp.getUpper());

			if(bmi>=low && bmi<=high){
				class = temp.getName();
				found = true;
				break;
			}
		}
		if(found){
			return class;
		}else {
			return "UNDEFINED";
		}
	}

	public int findName(String name){
		BMIRange temp = null;
		int index = -1;
		for (int i = 0; i < ranges.size(); i++) {
			temp = ranges.get(i);
			if(name.equals(temp.getName())){
				index = i;
				break;
			}
		}
		return index;
	}
}