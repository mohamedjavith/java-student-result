package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class result {
	int sid;
	String subcode;
	int mark;
	String result;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSubcode() {
		return subcode;
	}
	public void setSubcode(String subcode) {
		this.subcode = subcode;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public String addresult(int sid,String subcode,int mark) {
		try {
			Connection con = dbconnection.initializeDatabase();
			PreparedStatement st = con
	                  .prepareStatement("insert into results values(?, ?, ?, ?)");
			
			 st.setInt(1, sid);
	           st.setString(2, subcode);
	           st.setInt(3, mark);
	            if(mark < 40) {
	            	st.setString(4, "RA");
	            }else {
	            	st.setString(4, "PASS");
	            }
	           
	           st.executeUpdate();
	 
	         
	           st.close();
	           con.close();
	           return "Successfully Added";
			
		}catch (Exception e) {
	           e.printStackTrace();
	       }
		
		return "";
	}
	public String examresult(int sid) {
		try {
			Connection con = dbconnection.initializeDatabase();
			PreparedStatement st = con.prepareStatement("select * from results where sid=?");
			
			st.setInt(1,sid);
			
			ResultSet rs = st.executeQuery();
			String out = "";
			 while(rs.next()) 
             { 
				 
				 String subjectcode =  rs.getString("subjectcode");
				 int mark =  rs.getInt("mark"); 
				 String result =  rs.getString("result"); 
				
				 out = out + "<tr><td>"+subjectcode+"<td>"+mark+"<td>"+result+"</td></tr>";
             }
			 return out;
			
		}catch (Exception e) {
	           e.printStackTrace();
	       }
		return "";
	}
}
