package finki.emt.channelmanagement.domain.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import finki.emt.sharedkernel.domain.base.AbstractEntity;
import finki.emt.sharedkernel.domain.base.DomainObjectId;
import lombok.Getter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
public class User extends AbstractEntity<UserId> {

    private final String name;

    private final String email;

    private final String password;

    @OneToOne
    @JsonIgnore
    private Channel channel;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Channel> subscribedTo;

    protected User(){
        this.name = "";
        this.email = "";
        this.password = "";
    }
    public User(String name,String email,String password) {
        super(UserId.randomId(UserId.class));
        this.name = name;
        this.email = email;
        this.password = password;
        this.subscribedTo = new HashSet<>();
    }


    public void setSubscribedTo(Channel channel){
        this.subscribedTo.add(channel);
    }
    public void setChannel( Channel channel){
        this.channel= channel;
    }


}
