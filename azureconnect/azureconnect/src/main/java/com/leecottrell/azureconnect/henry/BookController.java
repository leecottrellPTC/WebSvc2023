package com.leecottrell.azureconnect.henry;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

/*
 * 
 * jdbc:sqlserver://cottrelldbserver.database.windows.net:1433;database=cottrellsql;user=studentLogin@cottrelldbserver;password=;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;
 */

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BookController {
    private String connectionString="jdbc:sqlserver://cottrelldbserver.database.windows.net:1433;database=cottrellsql;user=studentLogin@cottrelldbserver;password=a,plain3;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

    @RequestMapping(value="/Henry", method = RequestMethod.GET)
    public ResponseEntity<List<Book>>allBooks(){
        List response = new ArrayList<Book>();
        Book aBook = new Book();
        
        

        try{
            Connection con = DriverManager.getConnection(connectionString);
            Statement stmt = con.createStatement();
            String SQL = "select * from book order by title";
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

    @PostMapping(value="/Henry")
    public ResponseEntity<String> postNewBook(@RequestBody Book newBook){
        String response = newBook.getTitle() + " added";
        String SQL="";
        try{
            Connection con = DriverManager.getConnection(connectionString);
            Statement stmt = con.createStatement();
            //verify and sanitize inputs here
            SQL = String.format("insert into book values('%s', '%s', '%s','%s', '%s', '%s')",newBook.getBookCode(),
                newBook.getTitle(),
                newBook.getPublisherCode(),
                newBook.getType(),
                newBook.getPaperback(),
                newBook.getImage());
            stmt.execute(SQL);  
        }
        catch (Exception e){
            response = e.getMessage() + " -- " + SQL;
            return new ResponseEntity<String>(response, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
    @PutMapping(value="/Henry")
    public ResponseEntity<String> updateRecord(@RequestBody PutClass data){
        String response = data.getPrimaryKey() + " updated";
        String SQL="";
        try{
            Connection con = DriverManager.getConnection(connectionString);
            Statement stmt = con.createStatement();
            //verify and sanitize inputs here
            SQL = String.format("update book set %s = '%s' where bookCode = '%s'",
                data.getFieldName(), data.getValue(), data.getPrimaryKey());
            stmt.execute(SQL);  
        }
        catch (Exception e){
            response = e.getMessage() + " -- " + SQL;
            return new ResponseEntity<String>(response, HttpStatus.BAD_REQUEST);
        }


        return new ResponseEntity<String>(response, HttpStatus.OK);
    }
}
