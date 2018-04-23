package controllers_emergency;

import java.io.IOException;   

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Emergency;
import dbHelpers_emergency.UpdateEmergencyQuery;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet(description = "Controller which starts the actual emergency update to the database", urlPatterns = { "/updateEmergency" })
public class UpdateEmergencyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmergencyServlet() {
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
		// get the form data and set up a incident object
		int id = Integer.parseInt(request.getParameter("emergencyID"));
		String contact = request.getParameter("emergencyContact");
	    String operator = request.getParameter("drone_operator");
	    String actions = request.getParameter("operator_actions");
	    String comments = request.getParameter("operator_comments");

		
	 // set up a incident object
	    Emergency emergency = new Emergency();
	    emergency.setEmergencyID(id);
	    emergency.setEmergency_contact(contact);
	    emergency.setDrone_operator(operator);
	    emergency.setOperator_actions(actions);
	    emergency.setOperator_comments(comments);

		
		// create an UpdateQuery object and use it to update the book
		UpdateEmergencyQuery ueq = new UpdateEmergencyQuery("drone_incidents", "root", "");
		ueq.doUpdate(emergency);
		
		// pass control on to the ReadServlet
		String url = "/readEmergency";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
