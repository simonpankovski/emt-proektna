package finki.emt.videomanagement.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
@Entity
@Getter
@Setter
public class TagVideos {
    @Id
    private String id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Video video;
    @ManyToOne(fetch = FetchType.EAGER)
    @JsonIgnore
    private Tag tag;
}
