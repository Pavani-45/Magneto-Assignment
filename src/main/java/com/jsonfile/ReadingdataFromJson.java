package com.jsonfile;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadingdataFromJson {
    public String readFile(String attribute) throws FileNotFoundException, FileNotFoundException {
        JsonParser jsonParser = new JsonParser();
        FileReader reader = new FileReader(System.getProperty("user.dir")+"/Readdata/readingfile.json");
        Object obj=jsonParser.parse(reader);//C:\Users\Pavani Masanam\IdeaProjects\SauceDemo\Readdata\readingfile.json
        JsonObject jsonObject = (JsonObject) obj;
        String value = jsonObject.get(attribute).toString();
        return value;
    }
}

