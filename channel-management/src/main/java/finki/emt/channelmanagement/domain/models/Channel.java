package finki.emt.channelmanagement.domain.models;

import finki.emt.channelmanagement.domain.valueobjects.Subscribers;
import finki.emt.sharedkernel.domain.base.AbstractEntity;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "channel")
@Getter
public class Channel extends AbstractEntity<ChannelId> {
    private String name;
    private String about;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<User> subscribers;
    @OneToOne
    private User creator;
    public Channel( ) {
        super(ChannelId.randomId(ChannelId.class));
        this.name = "";


    }

    public Channel( String name,  User creator) {
        super(ChannelId.randomId(ChannelId.class));
        this.name = name;

        this.creator = creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }
    public void setAbout(String about){
        this.about = about;
    }
    public void setName(String name){
        this.name = name;
    }
}
