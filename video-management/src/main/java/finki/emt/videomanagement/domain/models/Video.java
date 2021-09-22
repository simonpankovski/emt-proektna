package finki.emt.videomanagement.domain.models;

import finki.emt.sharedkernel.domain.base.AbstractEntity;
import finki.emt.videomanagement.domain.valueobjects.Dislikes;
import finki.emt.videomanagement.domain.valueobjects.Likes;
import finki.emt.videomanagement.domain.valueobjects.UserId;
import lombok.Getter;
import lombok.NonNull;


import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "video")
@Getter
public class Video extends AbstractEntity<VideoId> {
    private final String name;
    private String location;

    private Likes likes;
    private final Instant createdOn;
    private Dislikes dislikes;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Tag> tags;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    private Set<Comment> comments;

    public Video(String name) {
        super(VideoId.randomId(VideoId.class));
        this.name = name;
        this.location = "";
        this.likes = new Likes();
        this.createdOn = Instant.now();
        this.dislikes = new Dislikes();
        this.tags = new HashSet<>();
        this.comments = new HashSet<>();
    }

    private Video() {
        super(VideoId.randomId(VideoId.class));
        this.name = "";
        this.createdOn = Instant.now();
    }

    public void addTag(Tag tag) {
        this.tags.add(tag);
    }
    public void removeTag(TagId tag) {
        this.tags.remove(tag);
    }
    public void addComment(Comment comment) {
        this.comments.add(comment);
    }
    public void removeComment(CommentId commentId) {
        this.comments.remove(commentId);
    }
    public void setLocation(String location){
        this.location = location;
    }
    public int incrementLikes(){
        return this.likes.increment();
    }
}
