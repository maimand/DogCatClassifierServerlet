package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BO.LoginBO;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final LoginBO loginBO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
    	this.loginBO = new LoginBO();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 response.sendRedirect("Register.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Logining");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		loginBO.addUser(username, password);
		response.sendRedirect(request.getContextPath() + "/login");
	}

}
