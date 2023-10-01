package com.scraft.application.ports;

import com.scraft.domain.Place;

import java.util.List;

public interface PlaceRetrieverPort {

    List<Place> getPlaces();

}
