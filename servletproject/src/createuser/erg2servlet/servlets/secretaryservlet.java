package createuser.erg2servlet.servlets;

import java.classes.secretary_work;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class secretaryservlet
 */
@WebServlet("/secretaryservlet")
public class secretaryservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private secretary_work work;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public secretaryservlet() {
        super();
        work = new secretary_work();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		PrintWriter out = response.getWriter();
		if(action.equals("login")) {
			int rn = Integer.parseInt(request.getParameter("rn"));
			String uname = request.getParameter("username");
	        boolean login=work.LoginSecretary(rn,uname);
	        if(login) {
	        	response.sendRedirect("secretraychoice.html");
	        }
        }else if(action.equals("showallcourses")) {
        	String courses=work.getAllCourses();
    		out.println(courses);
        }else if(action.equals("showcp")) {
        	String str=work.getAllCoursesAndProf();
        	out.print(str);
        }else if(action.equals("givecourse")){  	
        	response.sendRedirect("givecourses.html");
        }else if(action.equals("givenc")){
        	String rn = request.getParameter("rn");
			String cname = request.getParameter("cname");
        	work.GiveCourse(rn, cname);
        }
	}

}
