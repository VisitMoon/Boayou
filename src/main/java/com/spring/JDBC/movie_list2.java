package com.spring.JDBC;

import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class movie_list2 {
	
   public static void main(String[] args) {
	   for(int k = 0; k<=101405; k++) {
      try {
    	 
         // API 호출 및 XML 파싱
         URL url = new URL("https://api.koreafilm.or.kr/openapi-data2/wisenut/search_api/search_xml2.jsp?collection=kmdb_new2&startCount="+k+"&ServiceKey=U65BFFU8Y35796CWHB5J");
         
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         Document doc = dbFactory.newDocumentBuilder().parse(url.openStream());

         // DB 연결

         Class.forName("oracle.jdbc.driver.OracleDriver");

         Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##boayou", "boayou");

         // 삽입 쿼리 실행
         NodeList movieList = doc.getElementsByTagName("Result");
         String query = "INSERT INTO movie_list2 (docid ,title ,directorNm ,actorNm ,nation ,company ,plot ,runtime ,rating ,repRlsDate ,posters ,genre, fLocation)"
               + "VALUES (? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,?, ?)";
         // 넣을 테이블 이랑 컬럼
         PreparedStatement stmt = conn.prepareStatement(query);
         
         for (int i = 0; i < movieList.getLength(); i++) {
     	    Element element = (Element) movieList.item(i);
     	    String docid = element.getElementsByTagName("DOCID").item(0) == null ? "" : element.getElementsByTagName("DOCID").item(0).getTextContent();
     	    String title = element.getElementsByTagName("title").item(0)== null ? "" : element.getElementsByTagName("title").item(0).getTextContent();
     	    String directorNm = element.getElementsByTagName("directorNm").item(0)== null ? "" : element.getElementsByTagName("directorNm").item(0).getTextContent();
     	    String actorNm = element.getElementsByTagName("actorNm").item(0)== null ? "" : element.getElementsByTagName("actorNm").item(0).getTextContent();
     	    String nation = element.getElementsByTagName("nation").item(0)== null ? "" : element.getElementsByTagName("nation").item(0).getTextContent();
     	    String company = element.getElementsByTagName("company").item(0)== null ? "" : element.getElementsByTagName("company").item(0).getTextContent();
     	    String plot = element.getElementsByTagName("plot").item(0)== null ? "" : element.getElementsByTagName("plot").item(0).getTextContent();
     	    String runtime = element.getElementsByTagName("runtime").item(0)== null ? "" : element.getElementsByTagName("runtime").item(0).getTextContent();
     	    String rating = element.getElementsByTagName("rating").item(0)== null ? "" : element.getElementsByTagName("rating").item(0).getTextContent();
     	    String repRlsDate = element.getElementsByTagName("repRlsDate").item(0)== null ? "" : element.getElementsByTagName("repRlsDate").item(0).getTextContent();
     	    String posters = element.getElementsByTagName("posters").item(0) == null ? "" : element.getElementsByTagName("posters").item(0).getTextContent();     	
     	    String genre = element.getElementsByTagName("genre").item(0)== null ? "" : element.getElementsByTagName("genre").item(0).getTextContent();
     	    String fLocation = element.getElementsByTagName("fLocation").item(0)== null ? "" : element.getElementsByTagName("fLocation").item(0).getTextContent();

     	    
     	   if (posters.length()<11) {
      	        continue;
        	}

     	    stmt.setString(1, docid);
     	    stmt.setString(2, title);
     	    stmt.setString(3, directorNm);
     	    stmt.setString(4, actorNm);
     	    stmt.setString(5, nation);
     	    stmt.setString(6, company);
     	    stmt.setString(7, plot);
     	    stmt.setString(8, runtime);
     	    stmt.setString(9, rating);
     	    stmt.setString(10, repRlsDate);
     	    stmt.setString(11, posters);
     	    stmt.setString(12, genre);
     	    stmt.setString(13, fLocation);

     	   System.out.println(url);
     	   
     	    stmt.executeUpdate();
     	}
         
         stmt.close();
         conn.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
	   }
      
   }
}