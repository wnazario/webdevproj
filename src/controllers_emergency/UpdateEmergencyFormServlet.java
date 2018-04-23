package controllers_emergency;

import java.io.IOException;   

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Emergency;
import dbHelpers_emergency.ReadEmergencyRecord;

/**
 * Servlet implementation class UpdateFormServlet
 */
@WebServlet(description = "This will get an emergency and use the data to fill in a table for updating the record", urlPatterns = { "/update3" })
public class UpdateEmergencyFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmergencyFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the id
		int id = Integer.parseInt(request.getParameter("emergencyID"));
		
		// create ReadRecord class
		ReadEmergencyRecord rer = new ReadEmergencyRecord("drone_incidents", "root", "", id);
		
		// Use ReadRecord to get the product data
		rer.doRead();
		
		Emergency emergency = rer.getEmergency();
		
		// pass Incident and control to the updateForm.jsp
		request.setAttribute("emergency", emergency);
		
		String url = "/updateEmergencyForm.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
