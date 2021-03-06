package collectionsystem.controller.actions.services;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import collectionsystem.controller.Pages;
import collectionsystem.controller.actions.Action;
import collectionsystem.dao.ServiceDAO;
import collectionsystem.entities.Service;

public class ActionListingServices implements Action{
	private HttpServletRequest req;

	public ActionListingServices(HttpServletRequest req) {
		this.req = req;
	}
	
	public String execute() {
		List<Service> list = new ServiceDAO().lista();
		req.setAttribute("services", list);
		return Pages.SERVICES.toString();
	}
}
