package services;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.esprit.terabyte.DTO.SigDto;

@Stateful
@LocalBean
public class SigService implements SigServiceRemote{

	@Override
	public void Create(SigDto l) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:63238/api/AddSig");
		WebTarget hello =target.path("");
		
		Response response =hello.request().post(Entity.entity(l, MediaType.APPLICATION_JSON) );
		
		String result=response.readEntity(String.class);
		System.out.println(result);

		response.close();
		
	}

	@Override
	public List<SigDto> GetAll() {
		List<SigDto>  lasp = new ArrayList<SigDto>();
    	Client client = ClientBuilder.newClient();
    	
    	WebTarget web = client.target("http://localhost:63238/api/SigWebApi"); 
    	
    	Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	
    	JsonReader jsonReader = Json.createReader(new StringReader(result));
    	JsonArray object =  jsonReader.readArray();
  
    	for (int i=0;i<object.size();i++)
    	{
    	 
    		SigDto m = new SigDto();
    	 
    	 m.setIdPub(object.getJsonObject(i).getInt("idPub")); 
    	 m.setIdUser(object.getJsonObject(i).getString("idUser")); 
    	
    	 
    	 lasp.add(m);}
    	return lasp;
	}

	@Override
	public void Delete(SigDto l) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:63238/api/SigWebApi?idUser=cafc58b5-fe03-46c5-bd8f-f0f63860912c&idPub="+l.getIdPub());
		WebTarget hello =target.path("");
		
		Response response =hello.request().delete( );
		
		String result=response.readEntity(String.class);
		System.out.println(result);

		response.close();
		
	}

}
