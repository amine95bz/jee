package services;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

@Stateful
@LocalBean
public class Test implements TestRemote,TestLocale {

	@Override
	public void Consommation() {
		// create new jax-rs Client
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://jeedep-env.p9ijm22fnf.eu-west-1.elasticbeanstalk.com/api/RecWebApi");
		WebTarget hello =target.path("");
		Response response =hello.request().get();
		
		String result=response.readEntity(String.class);
		System.out.println(result);

		response.close();
		
	}

}
