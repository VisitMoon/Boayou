package com.spring.JDBC;

import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class boayouAPI {
	
   public static void main(String[] args) {
	   
      try {
    	 
         // API 호출 및 XML 파싱
         URL url = new URL("https://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.xml?itemPerPage=100&curPage=1&key=a767b52f901ec768ab58b20a6457e5d5");
         System.out.println(url);
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         Document doc = dbFactory.newDocumentBuilder().parse(url.openStream());

         // DB 연결

         Class.forName("oracle.jdbc.driver.OracleDriver");

         Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "c##boayou", "boayou");

         // 삽입 쿼리 실행
         NodeList movieList = doc.getElementsByTagName("movie");
         String query = "INSERT INTO movie_list (movieCd ,movieNm ,movieNmEn ,prdtYear ,openDt ,typeNm ,prdtStatNm ,nationAlt ,genreAlt ,repNationNm ,repGenreNm ,directors, peopleNm, companys, companyCd,companyNm)"
               + "VALUES (? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,? ,?,?,?,?,?)";
         // 넣을 테이블 이랑 컬럼
         PreparedStatement stmt = conn.prepareStatement(query);
         
         for (int i = 0; i < movieList.getLength(); i++) {
            Element element = (Element) movieList.item(i);
            String movieCd = element.getElementsByTagName("movieCd").item(0) == null ? "" : element.getElementsByTagName("movieCd").item(0).getTextContent();

//            String movieCd = element.getElementsByTagName("movieCd").item(0).getTextContent();
            String movieNm = element.getElementsByTagName("movieNm").item(0)== null ? "" : element.getElementsByTagName("movieNm").item(0).getTextContent();
            String movieNmEn = element.getElementsByTagName("movieNmEn").item(0)== null ? "" : element.getElementsByTagName("movieNmEn").item(0).getTextContent();
            String prdtYear = element.getElementsByTagName("prdtYear").item(0)== null ? "" : element.getElementsByTagName("prdtYear").item(0).getTextContent();
            String openDt = element.getElementsByTagName("openDt").item(0)== null ? "" : element.getElementsByTagName("openDt").item(0).getTextContent();
            String typeNm = element.getElementsByTagName("typeNm").item(0)== null ? "" : element.getElementsByTagName("typeNm").item(0).getTextContent();
            String prdtStatNm = element.getElementsByTagName("prdtStatNm").item(0)== null ? "" : element.getElementsByTagName("prdtStatNm").item(0).getTextContent();
            String nationAlt = element.getElementsByTagName("nationAlt").item(0)== null ? "" : element.getElementsByTagName("nationAlt").item(0).getTextContent();
            String genreAlt = element.getElementsByTagName("genreAlt").item(0)== null ? "" : element.getElementsByTagName("genreAlt").item(0).getTextContent();
            String repNationNm = element.getElementsByTagName("repNationNm").item(0)== null ? "" : element.getElementsByTagName("repNationNm").item(0).getTextContent();
            String repGenreNm = element.getElementsByTagName("repGenreNm").item(0)== null ? "" : element.getElementsByTagName("repGenreNm").item(0).getTextContent();
            String directors = element.getElementsByTagName("directors").item(0)== null ? "" : element.getElementsByTagName("directors").item(0).getTextContent();
            String peopleNm = element.getElementsByTagName("peopleNm").item(0)== null ? "" : element.getElementsByTagName("peopleNm").item(0).getTextContent();
            String companys = element.getElementsByTagName("companys").item(0)== null ? "" : element.getElementsByTagName("companys").item(0).getTextContent();
            String companyCd = element.getElementsByTagName("companyCd").item(0)== null ? "" : element.getElementsByTagName("companyCd").item(0).getTextContent();
            String companyNm = element.getElementsByTagName("companyNm").item(0)== null ? "" : element.getElementsByTagName("companyNm").item(0).getTextContent();
            


            stmt.setString(1, movieCd);
            stmt.setString(2, movieNm);
            stmt.setString(3, movieNmEn);
            stmt.setString(4, prdtYear);
            stmt.setString(5, openDt);
            stmt.setString(6, typeNm);
            stmt.setString(7, prdtStatNm);
            stmt.setString(8, nationAlt);
            stmt.setString(9, genreAlt);
            stmt.setString(10, repNationNm);
            stmt.setString(11, repGenreNm);      
            stmt.setString(12, directors);
            stmt.setString(13, peopleNm);
            stmt.setString(14, companys);
            stmt.setString(15, companyCd);
            stmt.setString(16, companyNm);
            

            stmt.executeUpdate();
         }
         
         stmt.close();
         conn.close();
      } catch (Exception e) {
         e.printStackTrace();
      }
	   
      
   }
}