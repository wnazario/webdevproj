package controllers;

import java.io.IOException; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dbHelpers.AddQuery;
import model.Incident;

/**
 * Servlet implementation class AddServlet
 */
@WebServlet(description = "Controller for adding a new incident to the database", urlPatterns = { "/addIncident" })
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get the data
	    String failure = request.getParameter("cause_of_failure");
	    String gps_location = request.getParameter("GPS_location");
	    String reported_by = request.getParameter("reported_by");
	    String damage = request.getParameter("damage_to_drone");
	    String external_damage = request.getParameter("external_dmg");
	    String policeReport = request.getParameter("police_incidence_report");
	    String contact = request.getParameter("emergency_phone_contact");
	    
	
		// set up a incident object
	    Incident incident = new Incident();
	    incident.setCause_of_failure(failure);
	    incident.setGPS_location(gps_location);
	    incident.setReported_by(reported_by);
	    incident.setDamage_to_drone(damage);
	    incident.setExternal_dmg(external_damage);
	    incident.setPolice_incidence_report(policeReport);
	    incident.setEmergency_phone_contact(contact);

	    
		// set up an addQuery object
	    AddQuery aq = new AddQuery("drone_incidents", "root", "");
	    
		// pass the product to addQuery to add to the database
	    aq.doAdd(incident);
	    
		// pass execution control to the ReadServlet
	    String url = "/read";
	    
	    RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	    dispatcher.forward(request, response);
	    
		
	}

}
