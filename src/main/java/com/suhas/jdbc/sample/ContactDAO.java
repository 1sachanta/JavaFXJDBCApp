package com.suhas.jdbc.sample;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ContactDAO extends DAO {

   private ContactPerson createContactPerson(ResultSet rs) {
      ContactPerson p = new ContactPerson();
      try {
         p.setId(rs.getInt("id"));
         p.setName(rs.getString("name"));
         p.setNickName(rs.getString("nick_name"));
         p.setAddress(rs.getString("address"));
         p.setHomePhone(rs.getString("home_phone"));
         p.setWorkPhone(rs.getString("work_phone"));
         p.setCellPhone(rs.getString("cell_phone"));
         p.setEmail(rs.getString("email"));
         p.setBirthDate(rs.getDate("birthday"));
         p.setWebSite(rs.getString("web_site"));
         p.setProfession(rs.getString("profession"));
      } catch (SQLException ex) {
      }
      return p;
   }
   
	public  ContactDAO() {
		super();
	}
	
   public List<ContactPerson> getContacts() {
      String sql = "Select * from contact order by name";
      List<ContactPerson> list = new ArrayList<>();
      try {
         Class.forName(driver);
         Connection con = DriverManager.getConnection (DB_URL, USER, PASS);
         Statement stmt = con.createStatement();
        
         ResultSet rs = stmt.executeQuery(sql);
         
         while (rs.next()) {
            ContactPerson p = createContactPerson(rs);
            list.add(p);
         }
         rs.close();
         con.close();
      } catch (ClassNotFoundException | SQLException ex) {
    	 System.out.print( ex.getMessage() );
      }
      return list;
   }

   public List<ContactPerson> getContactsForName(String name) {
      String sql = "Select * from contact where name like '%" +
         name + "%'";
      List<ContactPerson> list = new ArrayList<>();
      try {
         Class.forName(driver);
         Connection con = DriverManager.getConnection
            (DB_URL, USER, PASS);
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery(sql);
         while (rs.next()) {
            ContactPerson p = createContactPerson(rs);
            list.add(p);
         }
         rs.close();
         con.close();
      } catch (ClassNotFoundException | SQLException ex) {
      }
      return list;
   }
}
