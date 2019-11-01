package java.classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class secretary_work{

	private Connection c = null;
	public void secretary_work() {
		
		try {
			c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ergasia_programatismos","postgres", "pass");
        	}catch(Exception e) {
        		System.out.println("ERROR");
        		System.out.println(e);
        	}
		}
	
	public boolean LoginSecretary(int rn, String username) {
        boolean flag=false;
		try {
            PreparedStatement preparedStatement = c.prepareStatement("SELECT * FROM secretaries WHERE AM=?");
            preparedStatement.setInt(1, rn);
            ResultSet rs = preparedStatement.executeQuery();

            String uname = rs.getString("uname");
            int am = rs.getInt("AM");
            if(am==rn && uname.equals(username)) {
            	flag=true;
            }
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
		return flag;
    }
	
	
	public String getAllCourses() {
		String str="";
        try {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT course_name FROM courses");
            while (rs.next()) {
            	str+=rs.getString("course_name")+",";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return str;
    }
	
	
	public String getAllCoursesAndProf() {
		String str="";
        try {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM courses");
            while (rs.next()) {
            	String prof_am = rs.getString("AM");
            	String course=rs.getString("course_name");
            	statement = c.createStatement();
                rs = statement.executeQuery("SELECT name FROM professors WHERE AM="+prof_am);
                str+="professor: "+rs.getString("fname")+" course: "+course;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return str;
    }
	
	public void GiveCourse(String rn,String cname) {
		try {
			PreparedStatement preparedStatement = c.prepareStatement("INSERT INTO courses(course_name, AM) VALUES("+cname+","+rn+")");          
		}catch(SQLException e) {
            e.printStackTrace();
        }
		
		
	}
	
}
