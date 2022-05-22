package techscope;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/repairComputer")
public class repairComputer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cID=request.getParameter("cID");
		String com=request.getParameter("com");
		String del=request.getParameter("del");
		String date=request.getParameter("date");
		String des=request.getParameter("des");
		String spare=request.getParameter("spare");
		String qty=request.getParameter("qty");
		String cost=request.getParameter("cost");
		
		boolean istrue;
		
		istrue=repairDButil.insertComputerRepair(cID,com,del,date, des, spare, qty, cost);
		
		if(istrue==true)
		{
			RequestDispatcher dis=request.getRequestDispatcher("repairHome.jsp");
			dis.forward(request, response);
		}
		else
		{
			RequestDispatcher dis=request.getRequestDispatcher("repairFormComputer.jsp");
			dis.forward(request, response);
		}
	}
}

