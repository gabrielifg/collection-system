package collectionsystem.controller.actions.services;

import javax.servlet.http.HttpServletRequest;



import collectionsystem.dao.ServiceDAO;
import collectionsystem.entities.Service;

public class ActionSaveServices {
	private HttpServletRequest req;

	public ActionSaveServices(HttpServletRequest req) {
		this.req = req;
	}
	
	public String execute() {
		
		Service service = new Service();
		String idString = req.getParameter("id");
		
		if(idString != "") {
			long id = Long.parseLong(idString);
			service.setId(id);
		}
		
		String name = req.getParameter("input-nome");
		service.setName(name);
		ServiceDAO dao = new ServiceDAO();
		dao.save(service);
		
		String page = new ActionListingServices(req).execute();
		return page;
	}
}
