package com.scraft.application.finder;

import com.scraft.application.Randomizer;
import com.scraft.application.ports.PlaceRetrieverPort;
import com.scraft.domain.Place;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PlaceFinder {

    PlaceRetrieverPort retriever;

    public Place findRandomPlace() {
        Randomizer<Place> randomizer = new Randomizer<>();
        return randomizer.getRandomlyFrom(retriever.getPlaces());
    }

}
