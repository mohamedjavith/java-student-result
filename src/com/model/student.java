package com.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class student {
	int sid;
	String name;
	String city;
	String dept;


	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}
	public ArrayList<student> studentdetail(int sid,String password) {
		ArrayList<student> a = new ArrayList<student>();
		try { 
			Connection con = dbconnection.initializeDatabase();
			
			PreparedStatement st = con.prepareStatement("select * from student where sid=? and password=?");
			
			  st.setInt(1, sid); 
			  st.setString(2, password);
			 
			ResultSet rs = st.executeQuery();
			 while(rs.next()) 
            { 
				 student s = new student();
				 s.setSid(rs.getInt("sid")); 
				 s.setName(rs.getString("name"));
				 s.setCity(rs.getString("city"));
				 s.setDept(rs.getString("dept"));
				 a.add(s);
            }
			
		}
		
        catch (Exception e) {
            e.printStackTrace();
        }
		return a;
	}
	public String editstudent(int sid,String name,String city,String dept) {
		try { 
			Connection con = dbconnection.initializeDatabase();
			
			PreparedStatement st = con.prepareStatement("update student set name=?,city=?,dept=? where sid = ?");
			st.setString(1, name);
			st.setString(2, city);
			st.setString(3, dept);
			st.setInt(4, sid);
			
			st.executeQuery();
			con.close();
		}
        catch (Exception e) {
            e.printStackTrace();
        }
		return "successfully Inserted";
	}
	
	public String ListStudent() {
		try { 
			Connection con = dbconnection.initializeDatabase();
			
			PreparedStatement st = con.prepareStatement("select * from student");
			
			
			
			ResultSet rs = st.executeQuery();
			String out=""; 
			 while(rs.next()) 
             { 
				 int id =  rs.getInt("sid"); 
				 String name =  rs.getString("name");
				 String dept =  rs.getString("dept"); 
				 String city =  rs.getString("city"); 
				 
				
				 out = out + "<tr><td>"+id+"<td>"+name+"<td>"+dept+"</td><td>"+city;
				 out = out + "<td><a href=\"editstudent?id="+id+"\">Edit</a> ";
				 out = out +  "| <a href=\"deletestudent?sid="+id+"\">Delete</a></td></tr>";
				
            
             }
			 return out;
		}
        catch (Exception e) {
            e.printStackTrace();
        }
		return "";
	}
	public String addstudent(int sid,String name,String city,String dept,String password) {
		try {
			 Connection con = dbconnection.initializeDatabase();
			 
	           
	           PreparedStatement st = con
	                  .prepareStatement("insert into student values(?, ?, ?, ?, ?)");
	 
	   
	           st.setInt(1, sid);
	           st.setString(2,name);
	           st.setString(3, city);
	           st.setString(4, dept);
	           st.setString(5,password);
	           
	           st.executeUpdate();
	 
	          
	           st.close();
	           con.close();
		}
		catch (Exception e) {
	           e.printStackTrace();
	       }
		
		return "Successfully Added";
	}
}
