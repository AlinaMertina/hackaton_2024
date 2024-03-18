package com.hackaton.hariart.service.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.hackaton.hariart.mapping.Photo;
import com.hackaton.hariart.mapping.PythonResponse;

@Service
public class Api {

    public PythonResponse getPhotoTags(String photo) throws Exception{
        URL url = new URL("http://192.168.88.231:5000/getlabel");
        HttpURLConnection con = null;
        PythonResponse res = null;
        try{
            con = (HttpURLConnection) url.openConnection();
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);
            con.setDoInput(true);

            Photo pic = new Photo();
            pic.setImage_base64(photo);
            String jsonInputString = new Gson().toJson(pic);

            try(OutputStream outputStream = con.getOutputStream()){
                byte[] input = jsonInputString.getBytes(StandardCharsets.UTF_8);
                outputStream.write(input, 0, input.length);
            }

            int responseCode = con.getResponseCode();

            if(responseCode != HttpURLConnection.HTTP_OK && responseCode != 201){
                throw new IllegalCallerException("API Requst failed response code : " + responseCode);
            }

            StringBuilder response = new StringBuilder();
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()))){
                String line;
                while((line = reader.readLine()) != null){
                    response.append(line);
                } 
            }
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println("CON: " + con);
            res = objectMapper.readValue(response.toString(), PythonResponse.class);
        }catch(Exception e){
            throw e;
        }finally{
            if(con != null){
                con.disconnect();
            }
        }
        return res;
    }
}
