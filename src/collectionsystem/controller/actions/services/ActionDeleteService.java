package collectionsystem.controller.actions.services;

import javax.servlet.http.HttpServletRequest;

import collectionsystem.dao.ServiceDAO;
import collectionsystem.entities.Service;

public class ActionDeleteService {
	private HttpServletRequest req;

	public ActionDeleteService(HttpServletRequest req){
		this.req = req;
	}
	
	public String execute() {
		Service servico = new Service();
		String idString = req.getParameter("id");
		
		Long id = Long.parseLong(idString);
		servico.setId(id);
		new ServiceDAO().delete(servico);
		String pagina = new ActionListingServices(req).execute();
		return pagina;
	}
}
