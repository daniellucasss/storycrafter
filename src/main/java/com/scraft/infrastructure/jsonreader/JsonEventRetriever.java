package com.scraft.infrastructure.jsonreader;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.scraft.application.ports.EventRetrieverPort;
import com.scraft.domain.Event;
import org.springframework.stereotype.Component;

import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

@Component
public class JsonEventRetriever extends FileReader implements EventRetrieverPort {

    private static final String JSON_FILE_NAME = "events.json";

    public List<Event> getEvents() {
        JsonReader reader = new JsonReader(new StringReader(readStringJson(JSON_FILE_NAME)));
        reader.setLenient(true);

        return Arrays.asList(new Gson().fromJson(reader, Event[].class));
    }
}
