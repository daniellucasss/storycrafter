package com.scraft.infrastructure;

import com.scraft.application.StoryCrafter;
import com.scraft.domain.Story;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class StoryCrafterController {

    StoryCrafter storyCrafter;

    @GetMapping("/craft")
    public String craftAStory() {
        Story story = storyCrafter.craft();
        return story.tell();
    }

}
