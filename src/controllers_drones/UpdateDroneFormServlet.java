package controllers_drones;

import java.io.IOException;    

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Drone;
import dbHelpers_drones.ReadDroneRecord;

/**
 * Servlet implementation class UpdateFormServlet
 */
@WebServlet(description = "This will get a drone and use the data to fill in a table for updating the record", urlPatterns = { "/update2" })
public class UpdateDroneFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDroneFormServlet() {
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
		int id = Integer.parseInt(request.getParameter("droneID"));
		
		// create ReadRecord class
		ReadDroneRecord rdr = new ReadDroneRecord("drone_incidents", "root", "", id);
		
		// Use ReadRecord to get the product data
		rdr.doRead();
		
		Drone drone = rdr.getDrone();
		
		// pass Incident and control to the updateForm.jsp
		request.setAttribute("drone", drone);
		
		String url = "/updateDroneForm.jsp";
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
		
	}

}
