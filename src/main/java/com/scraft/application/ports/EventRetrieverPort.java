package com.scraft.application.ports;

import com.scraft.domain.Event;

import java.util.List;

public interface EventRetrieverPort {

    List<Event> getEvents();

}
