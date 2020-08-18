package com.api.memory.webservices.music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService {

    @Autowired
    MusicRepository repository;

    public List<Music> getAllMusic() {return repository.findAll();}


    public Music saveMusic(Music music) {
        return repository.save(music);
    }

    public void deleteMusic(Long id) {
        repository.deleteById(id);
    }
}
