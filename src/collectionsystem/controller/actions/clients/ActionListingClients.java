package collectionsystem.controller.actions.clients;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import collectionsystem.controller.Pages;
import collectionsystem.controller.actions.Action;
import collectionsystem.dao.ClientDAO;
import collectionsystem.entities.Client;

public class ActionListingClients implements Action{
	private HttpServletRequest req;

	public ActionListingClients(HttpServletRequest req) {
		this.req = req;
	}
	
	public String execute() {
		List<Client> list = new ClientDAO().lista();
		req.setAttribute("clients", list);
		return Pages.CLIENTS.toString();
	}
}
