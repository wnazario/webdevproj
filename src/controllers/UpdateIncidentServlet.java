package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Incident;
import dbHelpers.UpdateQuery;

/**
 * Servlet implementation class UpdateProductServlet
 */
@WebServlet(description = "Controller which starts the actual incident update to the database", urlPatterns = { "/updateIncident" })
public class UpdateIncidentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateIncidentServlet() {
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
		int id = Integer.parseInt(request.getParameter("incidentID"));
		String failure = request.getParameter("cause_of_failure");
	    String gps_location = request.getParameter("GPS_location");
	    String reported_by = request.getParameter("reported_by");
	    String damage = request.getParameter("damage_to_drone");
	    String external_damage = request.getParameter("external_dmg");
	    String policeReport = request.getParameter("police_incidence_report");
	    String contact = request.getParameter("emergency_phone_contact");
		
	 // set up a incident object
	    Incident incident = new Incident();
	    incident.setincidentID(id);
	    incident.setCause_of_failure(failure);
	    incident.setGPS_location(gps_location);
	    incident.setReported_by(reported_by);
	    incident.setDamage_to_drone(damage);
	    incident.setExternal_dmg(external_damage);
	    incident.setPolice_incidence_report(policeReport);
	    incident.setEmergency_phone_contact(contact);
		
		// create an UpdateQuery object and use it to update the book
		UpdateQuery uq = new UpdateQuery("drone_incidents", "root", "");
		uq.doUpdate(incident);
		
		// pass control on to the ReadServlet
		String url = "/read";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
