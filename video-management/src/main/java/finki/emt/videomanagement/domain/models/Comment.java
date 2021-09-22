package finki.emt.videomanagement.domain.models;

import finki.emt.sharedkernel.domain.base.AbstractEntity;
import finki.emt.videomanagement.domain.valueobjects.Dislikes;
import finki.emt.videomanagement.domain.valueobjects.Likes;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.Instant;

@Entity
@Table(name = "comment")
@Getter
public class Comment extends AbstractEntity<CommentId> {
    private final String name;
    private final Likes likes;
    private final Instant createdOn;
    private final String content;
    private final Dislikes dislikes;

    
    public Comment(String name, Likes likes, Instant createdOn, String content, Dislikes dislikes) {
        super(CommentId.randomId(CommentId.class));
        this.name = name;
        this.likes = likes;
        this.createdOn = createdOn;
        this.content = content;
        this.dislikes = dislikes;
    }
}
