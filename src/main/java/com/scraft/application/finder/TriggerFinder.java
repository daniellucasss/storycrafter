package com.scraft.application.finder;

import com.scraft.application.Randomizer;
import com.scraft.application.ports.ActionRetrieverPort;
import com.scraft.application.ports.ActorRetrieverPort;
import com.scraft.domain.Trigger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class TriggerFinder {

    ActorRetrieverPort actorRetriever;
    ActionRetrieverPort actionRetriever;

    public Trigger getRandomTrigger() {
        List<String> actors = actorRetriever.getActors();
        List<String> actions = actionRetriever.getActions();

        Randomizer<String> randomizer = new Randomizer<>();

        return new Trigger(randomizer.getRandomlyFrom(actions), randomizer.getRandomlyFrom(actors));
    }

}
