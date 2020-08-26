package com.api.memory.webservices.music;

import com.api.memory.webservices.user.ApplicationUser;
import com.api.memory.webservices.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Iterator;
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

        Music duplicateMusic = repository.findByYoutubeVideoId(music.getYoutubeVideoId());

        if ( duplicateMusic != null ) {
            duplicateMusic.getUsers().add(currentUser);
            return repository.save(duplicateMusic);
        } else {
            music.setUsers(userToAdd);
            return repository.save(music);
        }
    }

    public void deleteMusic(String youtubeVideoId) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userMail = authentication.getName();
        ApplicationUser currentUser = userRepository.findByEmail(userMail);

        Music musicToDelete = repository.findByYoutubeVideoId(youtubeVideoId);

        List<ApplicationUser> users = musicToDelete.getUsers();

        users.removeIf(user -> user.getId().equals(currentUser.getId()));
        musicToDelete.setUsers(users);

        if (musicToDelete.getUsers().size() == 0) {
            repository.delete(musicToDelete);
        } else {
            repository.save(musicToDelete);
        }
    }
}
