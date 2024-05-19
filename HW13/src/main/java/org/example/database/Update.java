package org.example.database;

import org.example.utils.Print;

import java.math.BigDecimal;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update extends BaseClass{

    PreparedStatement preStatement = null;

    public Update() {
        super();
    }

    public void updateAccountBalanceRecord(BigDecimal balance, int accountId){

        try{
            conn.close();
            conn = DriverManager.getConnection(CONNECTION_STRING);
            preStatement = conn.prepareStatement(UPDATE_ACCOUNT_SUM_STRING);
            preStatement.setBigDecimal(1, balance);
            preStatement.setInt(2,accountId);
            preStatement.executeUpdate();

        }catch(SQLException e){
            Print.consolePrint("Unable to update account balance in DB");
        }
    }
}
