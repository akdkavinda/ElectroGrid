package com.cebproject.CEBProject.resource;

import com.cebproject.CEBProject.model.crudmodel;
import com.cebproject.CEBProject.service.crudservice;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.*;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.core.MediaType;

@Path("/cebproject")
public class crudresource {
	
	crudservice service = new crudservice();

	@Path("/insertion")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public crudmodel addBranch(crudmodel branch) {
		return service.insertBranch(branch);
	}
	
	@Path("/retrieve")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<crudmodel>  getBranch() throws SQLException {
		return service.getbranch();
		
	}
	
	
	@Path("/retrieveById/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<crudmodel>  getBranch(@PathParam("id") int id) throws SQLException {
		return service.getbranchById(id);
		
	}
	
	@Path("/updatebranch")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public crudmodel updateBranch(crudmodel branch) {
		return service.updateBranch(branch);
	}
}
