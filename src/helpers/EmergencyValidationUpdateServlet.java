package helpers;

import helpers.Validator;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidationServlet
 */
@WebServlet("/ValidateEmergency2")
public class EmergencyValidationUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmergencyValidationUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "";
		String url = "/updateEmergency";

		//sets new userName String value from whatever has parameter from request object (in this case index.jsp)
		String contact = request.getParameter("emergencyContact");
						
		//if it is/not a name... appends to "msg" string
		if (!Validator.isName(contact)){
			msg += "The name has not been entered.<br />";
			url = "/inputErrors.jsp";
		} else if (!Validator.isShortName(contact)){
			msg += "The name should be no greater than 15 characters.<br />";
			url = "/inputErrors.jsp";
		} else {
				request.setAttribute("emergencyContact", contact);
			}
		

		request.setAttribute("msg", msg);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

