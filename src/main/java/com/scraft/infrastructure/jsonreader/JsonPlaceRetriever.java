package com.scraft.infrastructure.jsonreader;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.scraft.application.ports.PlaceRetrieverPort;
import com.scraft.domain.Place;
import org.springframework.stereotype.Component;

import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

@Component
public class JsonPlaceRetriever extends FileReader implements PlaceRetrieverPort {

    private static final String JSON_FILE_NAME = "places.json";

    public List<Place> getPlaces() {
        JsonReader reader = new JsonReader(new StringReader(readStringJson(JSON_FILE_NAME)));
        reader.setLenient(true);

        return Arrays.asList(new Gson().fromJson(reader, Place[].class));
    }

}
