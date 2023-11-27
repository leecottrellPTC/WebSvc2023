package com.leecottrelel.secureserver;
import java.nio.charset.Charset;
import org.apache.tomcat.util.codec.binary.Base64;
public class Secureclient {
    public String buildAuth(String username, String password){
         String authHeader = "";
        String temp = username + ":" + password;
        byte[] encoded = Base64.encodeBase64(temp.getBytes(Charset.forName("US-ASCII")),false);
        authHeader = "Basic " + encoded;
        return authHeader;
    }
    public static void main(String [] args){

    }
}
