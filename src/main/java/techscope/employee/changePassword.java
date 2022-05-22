package techscope.employee;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/changePassword")
public class changePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nic = request.getParameter("nic");
		String newpw = request.getParameter("new");

		boolean isTrue;
		
		isTrue = employeeDB.changePassword(nic,newpw);
		
		if (isTrue == true) {
			RequestDispatcher dis1 = request.getRequestDispatcher("employeeLogin.jsp");
			dis1.forward(request, response);
		}
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("newPassword.jsp");
			dis2.forward(request, response);
		}
	}
}
