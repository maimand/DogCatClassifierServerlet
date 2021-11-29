package controller;

import java.io.IOException;
import java.util.logging.Handler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.BO.LoginBO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LoginBO loginBO;
	
    public LoginController() {
        super();
        this.loginBO = new LoginBO();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	resp.sendRedirect("Login.jsp");
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		int userId = loginBO.checkLogin(username, password);
		if (userId > 0) {
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			response.sendRedirect("/");
		} else {
			//TODO: handle exception case 
			response.sendRedirect("/login");
		}
	}

}
