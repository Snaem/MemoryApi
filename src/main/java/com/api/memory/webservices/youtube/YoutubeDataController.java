package com.api.memory.webservices.youtube;

import com.api.memory.webservices.youtube.models.YoutubeData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/youtubeData")
public class YoutubeDataController {

    @Autowired
    YoutubeDataService service;

    @GetMapping
    public YoutubeData getStatistic(@RequestParam String youtubeVideoId){

        return service.getYoutubeData(youtubeVideoId);
    }

}
