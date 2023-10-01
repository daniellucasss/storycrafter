package com.scraft.domain;

public record Story(Place place, Trigger trigger, Event event, Ally ally, Event possibleEvent) {

    private static final String STORY_SHAPE = "%s %s %s. %s helps the group when their surprised by %s | Possibilities: %s";

    public String tell() {
        return String.format(STORY_SHAPE, trigger.actor(),
                trigger.action(), place.location(),
                ally.position(), event.plot(), possibleEvent().plot());
    }

}
