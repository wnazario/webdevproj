package controllers_drones;

import java.io.IOException; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Drone;
import dbHelpers_drones.UpdateDroneQuery;

/**
 * Servlet implementation class UpdateDroneServlet
 */
@WebServlet(description = "Controller which starts the actual drone update to the database", urlPatterns = { "/updateDrone" })
public class UpdateDroneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDroneServlet() {
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
		int id = Integer.parseInt(request.getParameter("droneID"));
		String make = request.getParameter("make");
	    String model = request.getParameter("model");
	    String year = request.getParameter("year");
	    String last_service = request.getParameter("last_service");
	    String service_loc = request.getParameter("service_loc");
	    String VIN = request.getParameter("VIN");
	    String faa_lic = request.getParameter("faa_lic");
		
	 // set up a incident object
	    Drone drone = new Drone();
	    drone.setDroneID(id);
	    drone.setMake(make);
	    drone.setModel(model);
	    drone.setYear(year);
	    drone.setLast_service(last_service);
	    drone.setService_loc(service_loc);
	    drone.setVIN(VIN);
	    drone.setFaa_lic(faa_lic);
		
		// create an UpdateQuery object and use it to update the book
		UpdateDroneQuery udq = new UpdateDroneQuery("drone_incidents", "root", "");
		udq.doUpdate(drone);
		
		// pass control on to the ReadServlet
		String url = "/readDrone";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
