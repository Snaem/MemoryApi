package com.api.memory.webservices.music;
import com.api.memory.webservices.user.ApplicationUser;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String youtubeVideoId;
    private String thumbnails;
    private String title;
    private Date addedAt;

    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name ="user_music",
            joinColumns = @JoinColumn(name="music_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<ApplicationUser> users;


    public Music() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYoutubeVideoId() {
        return youtubeVideoId;
    }

    public void setYoutubeVideoId(String youtubeVideoId) {
        this.youtubeVideoId = youtubeVideoId;
    }

    public String getThumbnails() {
        return thumbnails;
    }

    public void setThumbnails(String thumbnails) {
        this.thumbnails = thumbnails;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getAddedAt() {
        return addedAt;
    }

    public void setAddedAt(Date addedAt) {
        this.addedAt = addedAt;
    }

    public List<ApplicationUser> getUsers() {
        return users;
    }

    public void setUsers(List<ApplicationUser> users) {
        this.users = users;
    }
}