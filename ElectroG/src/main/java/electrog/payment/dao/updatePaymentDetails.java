package electrog.payment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;



import electrog.payment.model.update;

public class updatePaymentDetails {
	
	public static boolean updatePayment(update updateD) {

		Connection con = electrog.payment.dbconnection.dbConnection.connect();

		try {

			PreparedStatement ps = con.prepareStatement("update payment set cardType=?,cardNumber=?,expMonth=?,expYear=?,cvv=? where email=?");
			ps.setNString(1, updateD.getCardType());
			ps.setNString(2, updateD.getCardNumber());
			ps.setNString(3, updateD.getExpMonth());
			ps.setNString(4, updateD.getExpYear());
			ps.setNString(5, Integer.toString(updateD.getCvv()));
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
