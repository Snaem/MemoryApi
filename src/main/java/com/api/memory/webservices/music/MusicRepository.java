package com.api.memory.webservices.music;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicRepository extends JpaRepository<Music, Long> {

    Music findByYoutubeVideoId(String youtubeVideoId);
}
