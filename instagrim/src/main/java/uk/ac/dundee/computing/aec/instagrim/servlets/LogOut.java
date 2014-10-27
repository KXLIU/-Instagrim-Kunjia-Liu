package uk.ac.dundee.computing.aec.instagrim.servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uk.ac.dundee.computing.aec.instagrim.stores.LoggedIn;

/**
 * Servlet implementation class LogOut
 */
@WebServlet("/LogOut")
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogOut() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
	     
        LoggedIn lg= new LoggedIn();
        lg.setLogedout();
        session.setAttribute("LoggedIn", lg);
        System.out.println("Session in servlet "+session);
        RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
        rd.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost1(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doPost1(HttpServletRequest request, HttpServletResponse response)
			//throws ServletException, IOException {
		// TODO Auto-generated method stub
	        
	//}
}








