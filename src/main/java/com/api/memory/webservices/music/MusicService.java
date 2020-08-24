package com.api.memory.webservices.music;

import com.api.memory.webservices.user.ApplicationUser;
import com.api.memory.webservices.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MusicService {

    @Autowired
    MusicRepository repository;

    @Autowired
    UserRepository userRepository;

    public List<Music> getAllMusic() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        ApplicationUser currentUser = userRepository.findByUsername(userName);

        return currentUser.getMusics();
    }

    public Music saveMusic(Music music) {
        return repository.save(music);
    }

    public void deleteMusic(Long id) {
        repository.deleteById(id);
    }
}
