package finki.emt.videomanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class VideoName {
    private String name;
    @JsonCreator
    public VideoName(@JsonProperty("name") String name) {
        this.name = name;
    }
}
