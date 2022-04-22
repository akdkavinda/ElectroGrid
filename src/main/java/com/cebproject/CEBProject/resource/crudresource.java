package com.cebproject.CEBProject.resource;

import com.cebproject.CEBProject.model.crudmodel;
import com.cebproject.CEBProject.service.crudservice;

import jakarta.ws.rs.Path;
import jakarta.ws.rs.POST;
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
}
