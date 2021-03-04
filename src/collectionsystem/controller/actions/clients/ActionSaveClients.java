package collectionsystem.controller.actions.clients;

import javax.servlet.http.HttpServletRequest;

import collectionsystem.controller.actions.Action;
import collectionsystem.dao.ClientDAO;
import collectionsystem.entities.Client;


public class ActionSaveClients implements Action{
	
	private HttpServletRequest req;

	public ActionSaveClients(HttpServletRequest req) {
		this.req = req;
	}
	
	public String execute() {
		
		Client client = new Client();
		
		String cnpj = req.getParameter("input-cnpj");
		String name = req.getParameter("input-name");
		String nameFantasy = req.getParameter("input-nameFantasy");
		String cep = req.getParameter("input-cep");
		String publicPlace = req.getParameter("input-publicPlace");
		String number = req.getParameter("input-number");
		String complement = req.getParameter("input-complement");
		String uf = req.getParameter("cbx-uf");
		String county = req.getParameter("cbx-county");
		client.setCnpj(cnpj);
		client.setName(name);
		client.setNameFantasy(nameFantasy);
		client.setCep(cep);
		client.setPublicPlace(publicPlace);
		client.setNumber(number);
		client.setComplement(complement);
		client.setUf(uf);
		client.setCounty(county);
		ClientDAO dao = new ClientDAO();
		dao.save(client);
		
		String page = new ActionListingClients(req).execute();
		return page;
	}

}
