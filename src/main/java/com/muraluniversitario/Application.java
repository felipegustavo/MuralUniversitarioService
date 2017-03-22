package com.muraluniversitario;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import com.muraluniversitario.persistence.Connection;

@ApplicationPath("rest")
public class Application extends ResourceConfig {

	public Application() {
		packages("com.muraluniversitario.controller");
		Connection conn = Connection.getInstance();
		conn.connect("mongodb://localhost", "MuralUniversitario");
	}
	
}
