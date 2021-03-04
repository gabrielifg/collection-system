package collectionsystem.controller.actions.clients;

import javax.servlet.http.HttpServletRequest;

import collectionsystem.controller.Pages;
import collectionsystem.controller.actions.Action;
import collectionsystem.dao.ClientDAO;
import collectionsystem.entities.Client;



public class ActionLoadingClientData implements Action{
	
	private HttpServletRequest req;

	public ActionLoadingClientData(HttpServletRequest req) {
		this.req = req;
	}
	
	public String execute() {
		Client client = new Client();
		String cnpj = req.getParameter("cnpj");
		client = new ClientDAO().getClient(cnpj);

		req.setAttribute("client", client);
		return Pages.CLIENTS_FORM.toString();
	}

}
