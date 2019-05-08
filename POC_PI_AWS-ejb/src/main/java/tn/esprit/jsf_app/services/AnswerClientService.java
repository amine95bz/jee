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

import DTO.Answer;
import DTO.Quiz;

@LocalBean 
@Stateless

public class AnswerClientService implements AnswerClientServiceRemote  {
	
	public static final String baseUri = "http://localhost:63238/api/AnswerWebApi";
	private Client client = null;
	private WebTarget target = null;

	public AnswerClientService() {
		// TODO Auto-generated constructor stub
		client = ClientBuilder.newClient();
		target = client.target(baseUri);
	}

	public void reloadUri() {
		target = null;
		target = client.target(baseUri);
	}

	@Override
	public void postRequest(Answer p) {
		reloadUri();
		Answer pack = new Answer();
		pack.setQuestionID(p.QuestionID);
		pack.setResponseText(p.ResponseText);
		target = target.path("");
		Response response = target.request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(pack, MediaType.APPLICATION_JSON), Response.class);
		System.out.println(response);
		if (response.getStatus() == 200) {
			System.out.println("post success");

		} else
			System.out.println("fatal error");
	}

	@Override
	public void Consommation() {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:63238/api/AnswerWebApi");
		WebTarget hello = target.path("");
		Response response = hello.request().get();
		ObjectMapper mapper = new ObjectMapper();
		String result = response.readEntity(String.class);
		String ss = result;

		List<Answer> participantJsonList = null;
		try {
			participantJsonList = Arrays.asList(mapper.readValue(ss, Answer[].class));
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
		System.out.println("SSSSSSSSS" + participantJsonList);
		response.close();

	}

	@Override
	public List<Answer>  getall(){
		System.out.println("");
    	Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://localhost:63238/api/AnswerWebApi"); 
		WebTarget hello = target.path(""); 
    	Response res=(Response) hello.request().get();
    	List<Answer> post = res.readEntity(new GenericType<ArrayList<Answer>>() {});		 
		System.out.println("size of list is : "+post.size()+post);		 
		return post;

        }
	@Override
	public Answer getById(int questionId)
	{
		System.out.println("");
    	Client cl = ClientBuilder.newClient();
    	WebTarget target = cl.target("http://localhost:63238/api/AnswerWebApi"); 		
    	//WebTarget target = cl.target("http://jeedep-env.p9ijm22fnf.eu-west-1.elasticbeanstalk.com/api/AnswerWebApi");
		WebTarget hello = target.path(""+questionId);     	
    	Response res=(Response) hello.request().get();
    	
    	Answer answ = res.readEntity(Answer.class);
		System.out.println("answer"+answ);
		 
		return answ;
		
	}
	@Override
	public void DeleteById(int answerId)
	{
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://localhost:63238/api/AnswerWebApi"); 
		WebTarget hello = target.path(""+answerId);     	
    	Response res=(Response) hello.request().delete();
	}
	@Override
	public Response EditById(int answerId, Answer a)
	{
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://localhost:63238/api/AnswerWebApi");
		WebTarget hello = target.path(""+answerId);     	
    	Response res=(Response) hello.request().put(Entity.json(a));
    	return res;
		
	}
	@Override
	public void addAnswer(Answer a)
	{
		Client cl = ClientBuilder.newClient();
		WebTarget target = cl.target("http://localhost:63238/api/AnswerWebApi");
		WebTarget hello = target.path("");     	
    	Response res=(Response) hello.request().post(Entity.json(a));
	}
}

