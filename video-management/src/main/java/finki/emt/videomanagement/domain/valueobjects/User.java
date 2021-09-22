package finki.emt.videomanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.util.HashSet;
import java.util.Set;

@Getter
public class User {

    private final UserId id;
    private final String name;
    private final String email;
    private final String password;
    private final String channelName;
    private final Set<String> subedTochannels;
    private User() {
        this.id=UserId.randomId(UserId.class);
        this.name= "";
        this.email = "";
        this.password = "";
        this.channelName = "";
        this.subedTochannels = new HashSet<>();
    }

    @JsonCreator
    public User(@JsonProperty("id") UserId id,
                   @JsonProperty("productName") String name,
                   @JsonProperty("email") String email,
                   @JsonProperty("password") String password,
                @JsonProperty("channel") String channel,
                   @JsonProperty("subedTo") HashSet<String> subedTo) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.channelName = "";
        this.subedTochannels = subedTo;

    }

}
