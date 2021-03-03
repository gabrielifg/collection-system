package collectionsystem.controller.actions.services;

import javax.servlet.http.HttpServletRequest;

import collectionsystem.controller.actions.Action;
import collectionsystem.dao.ServiceDAO;
import collectionsystem.entities.Service;

public class ActionDeleteService implements Action{
	private HttpServletRequest req;

	public ActionDeleteService(HttpServletRequest req){
		this.req = req;
	}
	
	public String execute() {
		Service service = new Service();
		String idString = req.getParameter("id");
		
		Long id = Long.parseLong(idString);
		service.setId(id);
		new ServiceDAO().delete(service);
		String page = new ActionListingServices(req).execute();
		return page;
	}
}
