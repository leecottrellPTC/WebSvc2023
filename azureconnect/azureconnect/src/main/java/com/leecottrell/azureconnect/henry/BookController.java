package com.leecottrell.azureconnect.henry;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/*
 * 
 * jdbc:sqlserver://cottrelldbserver.database.windows.net:1433;database=cottrellsql;user=studentLogin@cottrelldbserver;password=a,plain3;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;
 */

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    @RequestMapping(value="/Henry", method = RequestMethod.GET)
    public ResponseEntity<List<Book>>allBooks(){
        List response = new ArrayList<Book>();
        Book aBook = new Book();
        
        String connectionString="jdbc:sqlserver://cottrelldbserver.database.windows.net:1433;database=cottrellsql;user=studentLogin@cottrelldbserver;password=a,plain3;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

        try{
            Connection con = DriverManager.getConnection(connectionString);
            Statement stmt = con.createStatement();
            String SQL = "select * from book where title like 'Harry%' order by title";
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()){
                aBook = new Book();
                aBook.setBookCode(rs.getString("BookCode"));//use the getDatatype
                aBook.setTitle(rs.getString("Title"));
                aBook.setPublisherCode(rs.getString("PublisherCode"));
                aBook.setType(rs.getString("Type"));
                aBook.setPaperback(rs.getString("Paperback"));
                aBook.setImage(rs.getString("Image"));
                response.add(aBook);
            }//end of while
            con.close();
        }
        catch(SQLException sex){
            aBook.setTitle("Bad SQL, username, or password");
            aBook.setImage(sex.toString());
            return new ResponseEntity(aBook, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
        return new ResponseEntity(response, HttpStatus.OK);
    }
}
