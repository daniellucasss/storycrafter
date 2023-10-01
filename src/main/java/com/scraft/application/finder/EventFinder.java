package com.scraft.application.finder;

import com.scraft.application.Randomizer;
import com.scraft.application.ports.EventRetrieverPort;
import com.scraft.domain.Event;
import org.springframework.stereotype.Component;

@Component
public class EventFinder {

    EventRetrieverPort retriever;
    Randomizer<Event> randomizer;

    public EventFinder(EventRetrieverPort retriever) {
        this.retriever = retriever;
        this.randomizer = new Randomizer<>();
    }

    public Event findRandomMainEvent() {
        return randomizer.getRandomlyFrom(retriever.getEvents().stream()
                .filter(Event::main)
                .toList());
    }

    public Event findRandomPossibleEvent() {
        return randomizer.getRandomlyFrom(retriever.getEvents().stream()
                .filter(event -> !event.main())
                .toList());
    }
}
