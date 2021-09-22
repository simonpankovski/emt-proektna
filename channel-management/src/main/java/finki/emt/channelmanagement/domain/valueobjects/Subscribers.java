package finki.emt.channelmanagement.domain.valueobjects;

import finki.emt.channelmanagement.domain.models.User;
import finki.emt.channelmanagement.domain.models.UserId;
import finki.emt.sharedkernel.domain.base.ValueObject;
import lombok.Getter;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Embeddable
@Getter
public class Subscribers implements ValueObject {
    @ElementCollection
    private final Set<UserId> subscribers;
    public Subscribers(){
        this.subscribers=new HashSet<>();;
    }
    public Subscribers(Set<UserId> list){
        this.subscribers = list;
    }
    public Subscribers increment(UserId user){

       if(this.subscribers.contains(user)){
            throw new IllegalArgumentException("User is already subscribed");
        }
        Set<UserId> tempSet = subscribers;
        tempSet.add(user);

        return new Subscribers(tempSet);
    }
    public Subscribers decrement(UserId user){

        if(!this.subscribers.contains(user)){
            throw new IllegalArgumentException("User is not subscribed");
        }
        Set<UserId> tempList = subscribers;
        tempList.remove(user);
        return new Subscribers(tempList);
    }
}
