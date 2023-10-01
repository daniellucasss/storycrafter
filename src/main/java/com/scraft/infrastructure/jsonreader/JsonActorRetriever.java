package com.scraft.infrastructure.jsonreader;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.scraft.application.ports.ActorRetrieverPort;
import org.springframework.stereotype.Component;

import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

@Component
public class JsonActorRetriever extends FileReader implements ActorRetrieverPort {

    private static final String JSON_FILE_NAME = "actors.json";

    public List<String> getActors() {
        JsonReader reader = new JsonReader(new StringReader(readStringJson(JSON_FILE_NAME)));
        reader.setLenient(true);

        return Arrays.asList(new Gson().fromJson(reader, String[].class));
    }
}
