package collectionsystem.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {
	@Id
	private String cnpj;
	
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String nameFantasy;
	@Column(nullable = false)
	private String cep;
	@Column(nullable = false)
	private String publicPlace;
	private String number;
	private String complement;

	private String uf;
	
	private String county;
	

	public Client() {

	}
	
	public Client(String cnpj, String name, String nameFantasy, String cep, String publicPlace, String number,
			String complement, String uf, String county) {
		super();
		this.cnpj = cnpj;
		this.name = name;
		this.nameFantasy = nameFantasy;
		this.cep = cep;
		this.publicPlace = publicPlace;
		this.number = number;
		this.complement = complement;
		this.uf = uf;
		this.county = county;
	}



	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameFantasy() {
		return nameFantasy;
	}

	public void setNameFantasy(String nameFantasy) {
		this.nameFantasy = nameFantasy;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getPublicPlace() {
		return publicPlace;
	}

	public void setPublicPlace(String publicPlace) {
		this.publicPlace = publicPlace;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}
}
