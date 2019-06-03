package wiley.automation.core.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;
import java.sql.Statement;

public class DBUtil
{
	//Logger
	//static Logger log = Logger.getLogger(DBUtil.class);
	
	static Connection con=null;
	static String ConnectionString = null;
	
	
	public static void SetConnectionDetails(String Host, String Port, String SID, String Username, String Password)
	{
		ConnectionString =  Username.trim() + "/" + Password.trim() + "@" + Host.trim() + ":" + Port.trim() + ":" + SID.trim();
		//log.debug("Connection String=" + ConnectionString);
	}
	
	private static void getConnection()
	{
		if(null==con && EnvUtil.getProperty("DB_ACCESS_ENABLED").equalsIgnoreCase("true"))
		{
		 	try //try connection to database
	        {
	            //load driver
	            Class.forName("oracle.jdbc.OracleDriver");
	            con=DriverManager.getConnection("jdbc:oracle:thin:" + ConnectionString);
	            //log.info("Oracle DB Connection Successful!");
	        }
	        catch (Exception e)
	        {
	            //log.fatal("Exception:"+e.getMessage());
	            //log.fatal("Oracle DB Connection NOT successful!");
	        }
		}
	}
	
	private static void closeConnection()
	{
		if(null!=con)
		{
			try 
			{
				con.close();	
			} 
			catch (SQLException e) 
			{
	            //log.fatal("Exception:"+e.getMessage());
	            //log.fatal("Oracle DB close connection NOT successful!");
			}
			finally
			{
				con = null;
			}	
		}	
	}
	
	public static void ExecuteUpdate(String Query)
	{
		//log.info("Query for passed for execution: \n" + Query);
		
		getConnection();
        Statement stmt = null;
        
        if(null!=con)
        {
    		try
    		{
    			stmt = con.createStatement();
    			stmt.setQueryTimeout(30);
    			stmt.executeUpdate(Query);
    			//log.info("Query executed Successfully!");
    		} 
    		catch(SQLTimeoutException  e)
    		{
    			//log.fatal("SQLTimeoutException\n" + e.getMessage());
    		}
    		catch (SQLException e) 
    		{
                //log.fatal("Exception:"+e.getMessage());
                //log.fatal("Oracle DB Connection NOT successful!");
    		}
    		finally
    		{
    			try 
    			{
    				stmt.close();
    				closeConnection();
    			}
    			catch (SQLException e)
    			{
    				e.printStackTrace();
    			}
    		}	
        }
        
	}
	
}