package com.api.memory.webservices.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/musics")
public class MusicController {

    @Autowired
    MusicService service;

    @GetMapping
    public List<Music> getAllMusic(){
        return service.getAllMusic();
    }

    @PostMapping
    public Music saveMusic(@RequestBody Music music) {
        return service.saveMusic(music);
    }

    @DeleteMapping
    public void deleteMusic(@RequestParam String youtubeVideoId) {
        service.deleteMusic(youtubeVideoId);
    }
}
