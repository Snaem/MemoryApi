package com.api.memory.webservices.music;

import com.api.memory.webservices.user.ApplicationUser;
import com.api.memory.webservices.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class MusicService {

    @Autowired
    MusicRepository repository;

    @Autowired
    UserRepository userRepository;

    public List<Music> getAllMusic() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userMail = authentication.getName();
        ApplicationUser currentUser = userRepository.findByEmail(userMail);

        return currentUser.getMusics();
    }

    public Music saveMusic(Music music) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userMail = authentication.getName();
        ApplicationUser currentUser = userRepository.findByEmail(userMail);

        List<ApplicationUser> userToAdd = new ArrayList<>();
        userToAdd.add(currentUser);

        music.setUsers(userToAdd);
        return repository.save(music);
    }

    public void deleteMusic(Long id) {
        repository.deleteById(id);
    }
}
