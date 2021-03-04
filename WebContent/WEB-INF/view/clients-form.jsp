<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Clients Form</title>
<script src="https://unpkg.com/axios/dist/axios.min.js"></script>
</head>
<body>
	<form action="clients" id="form" method="post">

		<input type="hidden" name="id" id="id"/>
		CNPJ <input required type="text" id="input-cnpj" name="input-cnpj" size="30" placeholder="00.000.000/0000-00"
		maxlength="14" value="${client.getCnpj()}"/>
		Name <input required type="text" id="input-name" name="input-name" placeholder="Ex.: Gabriel Eduardo" size="70" value="${client.getName()}"/>
		<p>Name Fantasy <input required type="text" id="input-nameFantasy" name="input-nameFantasy" placeholder="Insert  name fantasy here" size="70" value="${client.getNameFantasy()}"/></p>
		
		<p>CEP <input required type="number" id="input-cep" name="input-cep" size="30" placeholder="00000-000" maxlength="8" value="${client.getCep()}"/>
		Public Place <input required type="text" id="input-publicPlace" name="input-publicPlace" size="70" placeholder="Example Street"  value="${client.getPublicPlace()}"/></p>
		
		<p>Number <input type="number" id="input-number" name="input-number" size="30" maxlength="5" placeholder="00000"  value="${client.getNumber()}"/>
		Complement <input type="text" id="input-complement" name="input-complement" size="70" placeholder="Ex.: Court / Plot, Apartment"  value="${client.getComplement()}"/></p>
		
		<p>UF <select required class="select" id="uf" name="cbx-uf" style="width:80px"  value="${client.getUf()}">
			<option selected>----></option>
		</select>
		
		County <select required class="select" id="county" name="cbx-county" style="width:400px" value="${client.getCounty()}">
		<option selected></option>
		</select>
		
		</p>
		<p><input type="submit" id="save-button" name="btn-salva" value="save"/></p>
	
	</form>
	
	<p><a href="go?page=dashboard">back</a></p>
</body>
<script>
		
		getUF();
		var data={};
		const select_uf = document.getElementById('uf');
		const select_county = document.getElementById('county');
		
		select_uf.addEventListener('change', selectedItemUf)
		select_county.addEventListener('change',selectedItemCounty)
		function selectedItemUf(e){
			let uf = select_uf.options[select_uf.selectedIndex].text;
			data={
				...data,uf
			}
			removeOptions(select_county)
			getCounty(uf);	
		}
		function selectedItemCounty(e){
			let county = select_county.options[select_county.selectedIndex].text;
			data={
				...data,county
			}
			console.log(data)
		}
		
		function getUF(){
			axios.get('https://servicodados.ibge.gov.br/api/v1/localidades/estados').then(response=>{
				let data = response.data;
				data.map(uf=>{
					let option = document.createElement("option");
					option.text = uf.sigla
					select_uf.add(option);
					}
				);
			})
		}
		function getCounty(uf){
			console.log(uf);
			let url = "https://servicodados.ibge.gov.br/api/v1/localidades/estados/"+uf+"/municipios";
			console.log(url);
			axios.get(url).then(response=>{
				let data = response.data;
				data.map(county=>{
					let option = document.createElement("option");
					option.text = county.nome // AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII (NOME)
					select_county.add(option);
					}
				);
			})
		}
		function removeOptions(selectElement) {
		 let i; 
		 let L = selectElement.options.length - 1;
   			for(i = L; i >= 0; i--) {
      			selectElement.remove(i);
   			}
		}
	</script>
</html>