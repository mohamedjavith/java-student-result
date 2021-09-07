package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class staff {
	int staffid;
	String name;
	String dept;
	public int getStaffid() {
		return staffid;
	}
	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "staff [staffid=" + staffid + ", name=" + name + ", dept=" + dept + "]";
	}
	public ArrayList<staff> staffdetail(int staffid,String password) {
		ArrayList<staff> a = new ArrayList<staff>();
		try { 
			Connection con = dbconnection.initializeDatabase();
			
			PreparedStatement st = con.prepareStatement("select * from staff where staffid=? and password=?");
			
			  st.setInt(1, staffid); 
			  st.setString(2, password);
			 
			ResultSet rs = st.executeQuery();
			 while(rs.next()) 
            { 
				 staff s = new staff();
				 s.setStaffid(rs.getInt("staffid")); 
				 s.setName(rs.getString("name")); 
				 s.setDept(rs.getString("dept"));
				 a.add(s);
            }
			
		}
		
        catch (Exception e) {
            e.printStackTrace();
        }
		return a;
	}
	
	/*
	 * public static void main(String args[]) { staff s = new staff();
	 * ArrayList<staff> als = s.staffdetail(1201, "sakthidevi123");
	 * System.out.print(als.get(0).name);
	 * 
	 * }
	 */
}
