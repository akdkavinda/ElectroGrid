package electrog.payment.services;

import java.io.IOException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


import electrog.payment.dao.deletePaymentDetails;
import electrog.payment.dao.makePayment;
import electrog.payment.dao.showPaymentDetails;
import electrog.payment.dao.updatePaymentDetails;
import electrog.payment.model.cardDetails;
import electrog.payment.model.delete;
import electrog.payment.model.paymentDetails;
import electrog.payment.model.update;

@Path("/payment")
public class paymentServices {

	// make payment
	@Path("/insert")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String insertPayment(String p) throws JsonParseException, JsonMappingException, IOException {

		String str = null;


		try {

			ObjectMapper mapper = new ObjectMapper();
			paymentDetails pDetails = mapper.readValue( p, paymentDetails.class);
			str = makePayment.insertPaymentDetails(pDetails);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}


		return str;
	}
	
	
	//delete
	
		@Path("/deletepayment")
		@DELETE
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public String deletePaymentD(String s) {

			try {

				ObjectMapper objectMapper = new ObjectMapper();
				delete deleteP = objectMapper.readValue(s, delete.class);

				if (deletePaymentDetails.deletePayment(deleteP) == true) {

					return "payment details delete successfully";

				} else {
					return "deletion failed";
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

			return "fail";
		}
		
		
		//update
		// change password
		@Path("/update")
		@PUT
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public String updatePayment(String s) {

			try {

				ObjectMapper objectMapper = new ObjectMapper();
				update updateD = objectMapper.readValue(s, update.class);

				if( updatePaymentDetails.updatePayment(updateD) == true) {

					return "update details successfully";

				} else {
					return "update failed";
				}

			} catch (Exception e) {
				// TODO: handle exception
			}

			return "fail";
		}
		
		// login a user
		@Path("/show")
		@GET
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		public String loginUser(String s) throws JsonParseException, JsonMappingException, IOException {

			try {

				ObjectMapper objectMapper = new ObjectMapper();
				cardDetails cD = objectMapper.readValue(s, cardDetails.class);

				String result = showPaymentDetails.showDetails(cD);

			
					return result;

			} catch (Exception e) {
				e.printStackTrace();
			}
			return "fail";
		}




}
