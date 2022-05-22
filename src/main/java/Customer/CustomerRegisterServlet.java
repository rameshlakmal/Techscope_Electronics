package Customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CustomerRegisterServlet")
public class CustomerRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String full_Name=request.getParameter("name");
		String email=request.getParameter("email");
		String phone_No=request.getParameter("phone");
		String add=request.getParameter("add");
		String password=request.getParameter("pw");
		
		
		boolean istrue;
		istrue=customerDButil.insertCustomer(full_Name, email, phone_No, add, password);
		if(istrue==true)
		{

		
			RequestDispatcher dis=request.getRequestDispatcher("customerLogin.jsp");
			dis.forward(request,response);
		}
		else
		{
			RequestDispatcher dis2=request.getRequestDispatcher("customerRegister.jsp");
			dis2.forward(request,response);
		}
		
		
		
		
		
	}

}
