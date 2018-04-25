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
@WebServlet("/ValidateDrone")
public class DroneValidationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DroneValidationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String msg = "";
		String url = "/updateDrone";
		// name <= 15 characters
		//sets new userName String value from whatever has parameter from request object (in this case index.jsp)
		
		// year
		String year = request.getParameter("year");
		if (!Validator.isYear(year)){
			msg += "The year is not entered correctly.<br />";
			url = "/inputErrors.jsp";
		} else {
			 request.setAttribute("year", year);
			}
		
		// date of service
		String service = request.getParameter("last_service");
		if (!Validator.isDate(service)){
			msg += "The date of last service is not entered correctly.<br />";
			url = "/inputErrors.jsp";
		} else {
			request.setAttribute("last_service", service);
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

