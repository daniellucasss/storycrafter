package com.scraft.application.finder;

import com.scraft.application.Randomizer;
import com.scraft.application.ports.AllyRetrieverPort;
import com.scraft.domain.Ally;
import com.scraft.infrastructure.jsonreader.JsonAllyRetriever;
import org.springframework.stereotype.Component;

@Component
public class AllyFinder {

    AllyRetrieverPort retriever = new JsonAllyRetriever();

    public Ally findRandomAlly() {
        Randomizer<Ally> randomizer = new Randomizer<>();
        return randomizer.getRandomlyFrom(retriever.getAllies());
    }

}
