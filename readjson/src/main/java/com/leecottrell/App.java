package com.leecottrell;
import java.util.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.*;
import com.fasterxml.jackson.databind.*;
import java.io.*;
import java.nio.file.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static List<Company> companyList = new ArrayList<Company>();
    static int counter = 0;

    //read all the lines inthefile
    public static String readAllLines(String path){
        String content = "";
        try{
            content = new String(Files.readAllBytes(Paths.get(path)));
        }
        catch(IOException iex){
            System.out.println(iex.getMessage().toString());
            return "boo boo";
        }

        return content;
    }

    public static void findNACompanies(){
        int naCount = 0;
        for(Company aCompany: companyList){
            if(aCompany.getIndustry().equalsIgnoreCase("n/a")){
                naCount++;
                System.out.println(aCompany.getCompany());
            }
        }
        System.out.println("Companies with N/A " + naCount);
    }
    public static void main( String[] args )
    {
        String json;
        Company aCompany;
        ObjectMapper mapper = new ObjectMapper();
        json = readAllLines("c:\\data\\companies.json");
        //System.out.println(json);
        //System.out.println( "Hello World!" );
        try{
            companyList = mapper.readValue(json, new TypeReference<List<Company>>(){});//make the list
            counter = companyList.size();
            System.out.println("Lines read " + counter);
          //  System.out.println(companyList.get(5).toString());
            findNACompanies();
        }
        catch (Exception ex){
            System.out.println(ex.getMessage().toString());
            return;
        }
    }
}
