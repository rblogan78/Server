public class MyBMIServer{
		MyBMIAdmin admin;
	public MyBMIServer(){
		admin = new MyBMIAdmin();
	}

	public String calcBMI(String weight, String height){
		double w = Double.parseDouble(weight);
		double h = Double.parseDouble(height);
		h = h*0.01;
		double calc = w/(h*h);
		String class = admin.findRange(calc);
		String bmi = Double.toString(calc);
		String response = bmi+" "+class;
		return response;
	}

	public String listRanges(){

	}

	public String listWeights(String height){

	}
}