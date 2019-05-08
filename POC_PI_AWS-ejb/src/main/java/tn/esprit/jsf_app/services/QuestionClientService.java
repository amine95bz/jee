package tn.esprit.jsf_app.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import DTO.Pack;
import DTO.Question;
@LocalBean 
@Stateless
public class QuestionClientService implements QuestionClientServiceRemote {
	@Override
	public void Consommation() {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:63238/api/QuestionWebApi");
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

		// create new jax-rs Client
		/*
		 * Client client = ClientBuilder.newClient(); WebTarget target =
		 * client.target(
		 * "http://jeedep-env.p9ijm22fnf.eu-west-1.elasticbeanstalk.com/api/LogWebApi"
		 * ); WebTarget hello =target.path(""); Response response
		 * =hello.request().get();
		 * 
		 * String result=response.readEntity(String.class);
		 * System.out.println(result);
		 * 
		 * response.close();
		 */

	}

	public static final String baseUri = "http://localhost:63238/api/QuestionWebApi";

	private Client client = null;
	private WebTarget target = null;

	public QuestionClientService() {
		client = ClientBuilder.newClient();
		target = client.target(baseUri);
	}

	public void reloadUri() {
		target = null;
		target = client.target(baseUri);
	}

	@Override
	public void postRequest(Question p) {

		reloadUri();		
		Question pack = new Question();
		pack.setQuestionText(p.QuestionText);
		pack.setResponseId(p.ResponseId);
		target = target.path("");
		// POST Request from Jersey Client
		Response response = target.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(pack, MediaType.APPLICATION_JSON), Response.class);
		System.out.println(response);
		if (response.getStatus() == 200) {
			System.out.println("😕post success");

		} else {
			System.out.println("fatal error");
		}
	}

	@Override
	public void putRequest(int id, Question p) {
		Question pack = new Question();
		pack.setQuestionText(p.QuestionText);
		pack.setResponseId(p.ResponseId);
		

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:63238/api/QuestionWebApi?id=" + id);
		Response response = target.request().put(Entity.entity(pack, MediaType.APPLICATION_JSON));
		System.out.println(response);

	}

	@Override
	public void Consommationbyid(int id) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:63238/api/QuestionWebApi?id=" + id);
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
				.target("http://localhost:63238/api/QuestionWebApi?id=" + id);
		WebTarget hello = target.path("");
		Response response = hello.request(MediaType.APPLICATION_JSON_TYPE, MediaType.TEXT_PLAIN_TYPE).delete();

		System.out.println("LOG DELETED" + response.getStatus());
		String result = response.readEntity(String.class);
		System.out.println("XXXXXXXXXXX:" + result);

		response.close();

	}

}
