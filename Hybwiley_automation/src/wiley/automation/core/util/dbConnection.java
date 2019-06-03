package wiley.automation.core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


//import com.sybase.jdbc3.jdbc.SybDriver;
import com.sybase.jdbcx.*;

public class dbConnection {


	private static Connection con = null;
	private static Statement stmt = null;
	private static SybDriver sybDriver = null;

	public void testMain(Object[] args) {

	}

	public boolean getConnection(String strTimeout, String strDBName,
			String strDBURL, String strUserName, String strPassword) {
		boolean blResult = false;
		
		try {
			//Class.forName("com.sybase.jdbc4.jdbc.SybDriver");
			sybDriver = (SybDriver) Class.forName(strDBName).newInstance();
			DriverManager.setLoginTimeout(Integer.parseInt(strTimeout));
			for (int i = 0; i <= 20; i++) {
				try {
					con = DriverManager.getConnection(strDBURL, strUserName, strPassword);
				} catch (Exception e) {
					e.printStackTrace();
				}
				if (con != null) {
					stmt = con.createStatement();
					blResult = true;
					break;
				}
			}

		} catch (Exception e) {
			/*ResultUtil.report("FAIL", "Connecting to DB", "",
					"Unable to connect DB");*/
		}
		return blResult;
	}
	
	//srinivas
	
    public void  updateRecord(String strDBName, String strDBURL, String strUserName, String strPassword, String sSQLUpdateQuery, String sSelectSQLQuery) throws Exception  {
     try{
            sybDriver = (SybDriver) Class.forName(strDBName).newInstance();
            /*ResultUtil.report("INFO", "DataBase Driver", "", sybDriver.toString());*/
            con = DriverManager.getConnection(strDBURL, strUserName,strPassword);
            stmt = con.createStatement();
            stmt.executeUpdate(sSQLUpdateQuery);
            stmt.executeUpdate(sSelectSQLQuery);
          con.close();
                 
     	}catch(SQLException  e){
            /*ResultUtil.report("INFO", "updateRecord", "",
                         ""+e.getMessage());*/

     	}
     
    }


		public ArrayList<String> getValue(String strQueryDetails) {
		String[] strQuery = strQueryDetails.split(",");
		int noofcolumn = strQuery.length;
		ArrayList<String> getValue = new ArrayList<String>();
		ResultSet rs = null;
		try {
			/*ResultUtil.report("INFO", "Query to be execute " + strQuery[0], "",
					"");*/
			rs = stmt.executeQuery(strQueryDetails);
			rs.next();
			for (int i = 1; i <= noofcolumn; i++) {
				getValue.add(rs.getString(i));
			}
		} catch (Exception e) {
			/*ResultUtil.report("FAIL", "Unable to execute query : "
					+ strQuery[0], "", "");*/
			e.printStackTrace();
		} finally {
			closeRecordset(rs);
		}
		return getValue;
	}

	public ArrayList<String> getRowValue(String strQueryDetails) {
		String strQuery = strQueryDetails.split("\\|")[0];
		String strColumnName = strQueryDetails.split("\\|")[1];
		ArrayList<String> getValue = new ArrayList<String>();
		ResultSet rs = null;
		try {
			/*ResultUtil
					.report("INFO", "Query to be execute " + strQuery, "", "");*/
			rs = stmt.executeQuery(strQuery);
			while (rs.next()) {
				getValue.add(rs.getString(strColumnName));
			}
		} catch (Exception e) {
			
			/*ResultUtil.report("FAIL", "Unable to execute query : " + strQuery,
					"", ""+e.getMessage());*/
		} finally {
			closeRecordset(rs);
		}
		return getValue;
	}

	public String compareValue(String strQueryDetails) {
		String strQuery = strQueryDetails.split("\\|")[0];
		String strColumnName = strQueryDetails.split("\\|")[1];
		String getValue = "";
		ResultSet rs = null;

		try {
			//ResultUtil.report("INFO", "Query to be execute " + strQuery, "", "");
			rs = stmt.executeQuery(strQuery);
			rs.next();
			getValue = rs.getString(strColumnName);
		} catch (Exception e) {
			/*ResultUtil.report("FAIL", "Unable to execute query : " + strQuery
					+ e.getMessage(), "", "");*/
		} finally {
			closeRecordset(rs);
		}
		return getValue;
	}
	
	public String compareValue1(String strQueryDetails) {
		String strQuery = strQueryDetails.split("\\|")[0];
		String strColumnName = strQueryDetails.split("\\|")[1];
		String getValue = "";
		ResultSet rs = null;

		try {
			//ResultUtil.report("INFO", "Query to be execute " + strQuery, "", "");
			rs = stmt.executeQuery(strQuery);
			rs.next();
			getValue = rs.getString(strColumnName);
		} catch (Exception e) {
			/*ResultUtil.report("INFO", "Unable to execute query : " + strQuery
					+ e.getMessage(), "", "");*/
		} finally {
			closeRecordset(rs);
		}
		return getValue;
	}

	/**
	 * Description : To execute DB query
	 * 
	 * @author sasikala.k
	 */
	public boolean runQuery(String strQuery) {

		Boolean blResult = false;

		try {
			int count = 0;
			count = stmt.executeUpdate(strQuery);
			/*ResultUtil.report("PASS", "Executed Query : " + strQuery,
					"No. of rows should be affected: " + count,
					"No. of rows affected: " + count);*/
			blResult = true;
		} catch (Exception e) {
			e.printStackTrace();
			/*ResultUtil.report("FAIL", "Unable to execute query : " + strQuery
					+ e.getMessage(), "", "");*/
		} finally {
		}
		return blResult;
	}

	private static void closeRecordset(ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {

		}
	}

	public void endConnection() {
		try {
			stmt.close();
			con.close();
		} catch (Exception e) {
			/*ResultUtil.report("FAIL",
					"Exception occured on endConnection method", "", ""+e.getMessage());*/
		}
	}	
}
