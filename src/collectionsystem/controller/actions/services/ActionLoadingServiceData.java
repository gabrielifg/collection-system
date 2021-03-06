package collectionsystem.controller.actions.services;

import javax.servlet.http.HttpServletRequest;

import collectionsystem.controller.Pages;
import collectionsystem.controller.actions.Action;
import collectionsystem.dao.ServiceDAO;
import collectionsystem.entities.Service;

public class ActionLoadingServiceData implements Action{
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
		return Pages.SERVICES_FORM.toString();
	}
}
