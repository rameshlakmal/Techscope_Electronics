package Customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

;


@WebServlet("/CustomerUpdateServlet")
public class CustomerUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

		String id=request.getParameter("id");
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		String add=request.getParameter("add");
	
		boolean istrue;
		istrue=customerDButil.UpdateCustomer(id, name, email, phone, add);
		
		if(istrue==true)
		{

			List<Customer>cusDetails=customerDButil.getUpdateDetails(email);
			request.setAttribute("cusDetails", cusDetails);
			RequestDispatcher dis=request.getRequestDispatcher("Customerprofile.jsp");
			dis.forward(request,response);
		}
		else
		{
			RequestDispatcher dis2=request.getRequestDispatcher("Unsuccess.jsp");
			dis2.forward(request,response);
		}
		
		
	}

}
