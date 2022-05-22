package techscope.employee;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/forgotPassword")
public class forgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nic = request.getParameter("nic");
		String email = request.getParameter("email");
		String date = request.getParameter("date");
		
		boolean isTrue = employeeDB.forgotPasword(nic, email, date);
		
		if(isTrue == true) {
				try {
					List<employee> empProf = employeeDB.newPassword(nic, email, date);
					request.setAttribute("empProf", empProf);
				}
				catch(Exception e) {
					e.printStackTrace();
					System.out.println("aaaa");
				}
			RequestDispatcher dis = request.getRequestDispatcher("newPassword.jsp");
			dis.forward(request, response);
		}
		else {
			RequestDispatcher dis = request.getRequestDispatcher("forgotPassword.jsp");
			dis.forward(request, response);
		}
	}
}


