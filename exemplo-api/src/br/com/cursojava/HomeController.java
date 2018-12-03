package br.com.cursojava;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

@Path("home")
public class HomeController {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String,String> getData(@Context HttpServletRequest request){
		System.out.println(request);
		Map<String, String> mapa = new HashMap<>();
		mapa.put("mensagem", "Oi!!!");
		return mapa;
	}

}
