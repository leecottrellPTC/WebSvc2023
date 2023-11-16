package com.leecottrell;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import java.util.*;

public class App 
{

    final static CloseableHttpClient httpClient = HttpClients.createDefault();
    public static void getCheck() throws Exception{
        //pass in parameter
        HttpGet request = new HttpGet("http://localhost:8080/rooms");
       // HttpGet request = new HttpGet("http://localhost:8080/rooms?roomNum=515");
        CloseableHttpResponse response = httpClient.execute(request);
        HttpEntity entity = response.getEntity();
        
        ObjectMapper mapper = new ObjectMapper();
        List<Rooms> rooms = new ArrayList<Rooms>();
        rooms = mapper.readValue(EntityUtils.toString(entity), new TypeReference<List<Rooms>>() {});

        for(Rooms room : rooms){
            System.out.println(room.toString());
        }
    }

    public static void postCheck() throws Exception{
        HttpPost request = new HttpPost("http://localhost:8080/rooms");
        Rooms newRoom = new Rooms(420, "Snoop Dogg");

        ObjectMapper mapper = new ObjectMapper();
        StringEntity json = new StringEntity(mapper.writeValueAsString(newRoom), ContentType.APPLICATION_JSON);
        request.setEntity(json);

        CloseableHttpResponse response = httpClient.execute(request);
        if(response.getStatusLine().getStatusCode() !=200){
            System.out.println(newRoom.toString() + " not added - fix this!! ");
        }
    }
    public static void main( String[] args ) throws Exception
    {
        postCheck();
       getCheck();

    }
}
