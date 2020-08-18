package com.api.memory.webservices.youtube;

import com.api.memory.webservices.youtube.models.YoutubeData;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class YoutubeDataService {

    public YoutubeData getYoutubeData(String youtubeVideoId) {

        WebClient webClient = WebClient
                .builder()
                .baseUrl("https://www.googleapis.com/youtube/v3")
                .build();

        return webClient.get()

                .uri(UriBuilder -> UriBuilder
                        .path("/videos")
                        .queryParam("part", "snippet")
                        .queryParam("id", youtubeVideoId)
                        .queryParam("maxResults", 1)
                        .queryParam("key", System.getenv("youtube_api"))
                        .build())
                .retrieve()
                .bodyToMono(YoutubeData.class).block();


    }
}
