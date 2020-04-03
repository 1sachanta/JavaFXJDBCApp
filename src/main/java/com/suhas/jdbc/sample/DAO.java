package com.suhas.jdbc.sample;

import java.util.Properties;
import java.util.*;
import java.io.*;


public class DAO {
	   //public static final String DB_URL =
	//      "jdbc:mysql://testdb.c87oictu3b1l.us-east-1.rds.amazonaws.com:3306/" +"testdb?zeroDateTimeBehavior=convertToNull";
	   public static final String DRIVER =
	      "com.mysql.jdbc.Driver";
	//   public static final String USER = "admin";
	//   public static final String PASS = "Password1";
	   public   String USER ;
	   public   String PASS;
	   
	   public static final String PROP_FILE="mysql-properties.xml";
	   private Properties prop;
	   private String driver;
	   private String serverName;
	   private int portNumber;
	   public String dbms;
	   public String jarFile;
	   public String dbName; 
	   public String userName;
	   public String password;
	   public String urlString;
	   public String DB_URL;
	   

	   public DAO()
	   {
		  try {
          setProperties();
		  } catch (Exception ex)
		  {
			  System.out.println(ex.getMessage() ) ;
			  ex.printStackTrace();
		  }
	   }
	   
	   private void setProperties() throws FileNotFoundException, IOException, InvalidPropertiesFormatException {
		   this.prop = new Properties();
		
		   //String basePath = DAO.class.getResource("/").getPath();
		   
		 //System.out.println("basepath" + basePath);
		   
		 //FileInputStream fis = new FileInputStream(PROP_FILE);

		   InputStream fis = getClass().getClassLoader().getResourceAsStream(PROP_FILE);
		   //System.out.println("fis is" + fis.toString());
		   
		   prop.loadFromXML(fis);

		   this.dbms = this.prop.getProperty("dbms");
		   this.jarFile = this.prop.getProperty("jar_file");
		   this.driver = this.prop.getProperty("driver");
		   this.dbName = this.prop.getProperty("database_name");
		   this.USER = this.prop.getProperty("user_name");
		   this.PASS = this.prop.getProperty("password");
		   this.serverName = this.prop.getProperty("server_name");
		   this.portNumber = Integer.parseInt(this.prop.getProperty("port_number"));
		   this.DB_URL=("jdbc:mysql://"+this.serverName +":"+this.portNumber +"/"+ this.dbName + "?zeroDateTimeBehavior=convertToNull");
		  // System.out.println(DB_URL);

}


	   
	}
