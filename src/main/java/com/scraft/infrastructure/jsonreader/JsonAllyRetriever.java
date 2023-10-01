package com.scraft.infrastructure.jsonreader;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.scraft.application.ports.AllyRetrieverPort;
import com.scraft.domain.Ally;
import org.springframework.stereotype.Component;

import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

@Component
public class JsonAllyRetriever extends FileReader implements AllyRetrieverPort {

    private static final String JSON_FILE_NAME = "allies.json";

    public List<Ally> getAllies() {
        JsonReader reader = new JsonReader(new StringReader(readStringJson(JSON_FILE_NAME)));
        reader.setLenient(true);

        return Arrays.asList(new Gson().fromJson(reader, Ally[].class));
    }

}
