package collectionsystem.controller.actions.clients;

import javax.servlet.http.HttpServletRequest;

import collectionsystem.controller.actions.Action;
import collectionsystem.dao.ClientDAO;
import collectionsystem.entities.Client;


public class ActionDeleteClient implements Action{
	private HttpServletRequest req;

	public ActionDeleteClient(HttpServletRequest req){
		this.req = req;
	}
	
	public String execute() {
		Client client = new Client();
		String cnpj = req.getParameter("cnpj");
		
		client.setCnpj(cnpj);
		new ClientDAO().delete(client);
		String page = new ActionListingClients(req).execute();
		return page;
	}
}
