package collectionsystem.controller.actions.services;

import javax.servlet.http.HttpServletRequest;

import collectionsystem.dao.ServiceDAO;
import collectionsystem.entities.Service;

public class ActionLoadingServiceData {
	private HttpServletRequest req;

	public ActionLoadingServiceData(HttpServletRequest req) {
		this.req = req;
	}
	
	public String execute() {
		
		Service service = new Service();
		String idString = req.getParameter("id");
		long id = Long.parseLong(idString);
		
		service = new ServiceDAO().getService(id);
		req.setAttribute("service", service);
		return "services-form.jsp";
	}
}
