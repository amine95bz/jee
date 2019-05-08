package tn.esprit.jsf_app.services;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import DTO.Pack;
@Stateless
@LocalBean
public class PackClientService implements PackClientServiceRemote {
	@Override
	public List<Pack> Consommation() {

		Client client = ClientBuilder.newClient();
		
		//WebTarget target = client.target("http://like-env.za5kp6hseg.eu-west-1.elasticbeanstalk.com/api/PackWebApi");
		WebTarget target = client.target("http://localhost:63238/api/PackWebApi");
		WebTarget hello = target.path("");
		Response response = hello.request().get();
		ObjectMapper mapper = new ObjectMapper();
		String result = response.readEntity(String.class);
		String ss = result;
		List<Pack> participantJsonList = null;
		try {
			participantJsonList = Arrays.asList(mapper.readValue(ss, Pack[].class));
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("SSSSSSSSS😕" + participantJsonList);
		response.close();
		return participantJsonList;
	}

	public static final String baseUri = "http://localhost:63238/api/pac";
	private Client client = null;
	private WebTarget target = null;
	public PackClientService() {
		client = ClientBuilder.newClient();
		target = client.target(baseUri);
	}
	public void reloadUri() {
		target = null;
		target = client.target(baseUri);
	}

	@Override
	public void postRequest(Pack p) {

		reloadUri();
		Pack pack = new Pack();
		pack.setDescription(p.Description);
		pack.setPackName(p.PackName);
		pack.setNbClient(p.NbClient);
		pack.setPrice(p.price);
		pack.setImagePath(p.ImagePath);
		target = target.path("");
		Response response = target.request(MediaType.APPLICATION_JSON).post(Entity.entity(pack, MediaType.APPLICATION_JSON), Response.class);
		System.out.println(response);
		if (response.getStatus() == 200) {
			System.out.println("😕post success");

		} else {
			System.out.println("fatal error");
		}
	}

	@Override
	public void putRequest(int id, Pack p) {
		Pack pack = new Pack();
		pack.setDescription(p.Description);
		pack.setNbClient(p.NbClient);
		pack.setPackName(p.PackName);
		pack.setPrice(p.price);
		pack.setImagePath(p.ImagePath);
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:63238/api/PackUp?id=" + id);
		Response response = target.request().put(Entity.entity(pack, MediaType.APPLICATION_JSON));
		System.out.println(response);

	}

	@Override
	public void Consommationbyid(int id) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:63238/api/PackWebApi?id=" + id);
		WebTarget hello = target.path("");
		Response response = hello.request().get();

		String result = response.readEntity(String.class);
		System.out.println("XXXXXXXXXXX:" + result);

		response.close();

	}

	@Override
	public void DelRequest(int id) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client
				.target("http://localhost:63238/api/PackWebApi?id=" + id);
		WebTarget hello = target.path("");
		Response response = hello.request(MediaType.APPLICATION_JSON_TYPE, MediaType.TEXT_PLAIN_TYPE).delete();

		System.out.println("LOG DELETED" + response.getStatus());
		String result = response.readEntity(String.class);
		System.out.println("XXXXXXXXXXX:" + result);

		response.close();

	}
	
	@Override
	public List<Pack> GetAll() {
		List<Pack> packs= new ArrayList<>();
		
    	Client client = ClientBuilder.newClient();
    	///http://like-env.za5kp6hseg.eu-west-1.elasticbeanstalk.com/
    	
    	WebTarget web = client.target("http://localhost:63238/api/PackWebApi"); 
    	
    	Response response = web.request().get();
    	
    	String result = response.readEntity(String.class); 
    	
    	//System.out.println(result);
    	JsonReader jsonReader = (JsonReader) Json.createReader(new StringReader(result));
    	JsonArray object =  (jsonReader).readArray();
    	//SimpleDateFormat sfd = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
    	for (int i=0;i<object.size();i++)
    	{
    	 
    		Pack m = new Pack();
    	 
    	 m.setPackId(object.getJsonObject(i).getInt("PackId")); 
    	 m.setDescription(object.getJsonObject(i).getString("Description")); 
    	 m.setNbClient(object.getJsonObject(i).getInt("NbClient"));
    	 m.setImagePath(object.getJsonObject(i).getString("image"));
    	 m.setPrice(object.getJsonObject(i).getInt("price"));
    	 
    	 packs.add(m);
    	}
    	

return packs;    	
	}

	}
