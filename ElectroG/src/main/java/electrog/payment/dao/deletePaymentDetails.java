package electrog.payment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import electrog.payment.dbconnection.dbConnection;
import electrog.payment.model.delete;

public class deletePaymentDetails {
	
	public static boolean deletePayment(delete deleteP) {

		Connection con = dbConnection.connect();

		try {

			PreparedStatement ps = con.prepareStatement("DELETE FROM payment WHERE email=?");
			ps.setNString(1, deleteP.getEmail());
			int i = ps.executeUpdate();

			if (i > 0) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}

	}
}
