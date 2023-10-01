package com.scraft.application;

import com.scraft.application.finder.AllyFinder;
import com.scraft.application.finder.EventFinder;
import com.scraft.application.finder.PlaceFinder;
import com.scraft.application.finder.TriggerFinder;
import com.scraft.domain.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StoryCrafter {

    PlaceFinder placeFinder;
    TriggerFinder triggerFinder;
    EventFinder eventFinder;
    AllyFinder allyFinder;

    public Story craft() {
        Place place = placeFinder.findRandomPlace();
        Trigger trigger = triggerFinder.getRandomTrigger();
        Event event = eventFinder.findRandomMainEvent();
        Event possibleEvent = eventFinder.findRandomPossibleEvent();
        Ally ally = allyFinder.findRandomAlly();

        return new Story(place, trigger, event, ally, possibleEvent);
    }
}
