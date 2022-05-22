package techscope.employee;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/profileUpdateNew")
public class profileUpdateNew extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String newposition = request.getParameter("newposition");
		
		boolean isTrue;
		
		isTrue = employeeDB.addNewPosition(newposition);
		
		if (isTrue == true) {
			RequestDispatcher dis1 = request.getRequestDispatcher("profileUpdate.jsp");
			dis1.forward(request, response);
		}
		else {
			RequestDispatcher dis2 = request.getRequestDispatcher("profileUpdateNew.jsp");
			dis2.forward(request, response);
		}
	}

}
