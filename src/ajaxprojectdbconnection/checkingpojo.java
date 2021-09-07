package ajaxprojectdbconnection;

import com.google.gson.Gson;

public class checkingpojo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mobile m1 = new mobile("realme",20000,"6GB");
		
		System.out.println(m1.toString());
		System.out.println(new Gson().toJson(m1)); 
	}

}
