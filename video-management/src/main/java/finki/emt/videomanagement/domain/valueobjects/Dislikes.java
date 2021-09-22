package finki.emt.videomanagement.domain.valueobjects;

import finki.emt.sharedkernel.domain.base.ValueObject;
import lombok.Getter;

import javax.persistence.*;
import java.util.*;

@Embeddable
@Getter
public class Dislikes implements ValueObject {
    @ElementCollection(targetClass=UserId.class)
    private Set<UserId> dislikes;
    public Dislikes(){
        this.dislikes= new HashSet<>();
    }
    public Dislikes(Set<UserId> users){
        this.dislikes = users;
    }
    public int increment(UserId user){
        this.dislikes.add(user);
        return this.dislikes.size();
    }

    public int decrement(UserId user){
        this.dislikes.remove(user);
        return this.dislikes.size();
    }
    public int count(){
        return this.dislikes.size();
    }
}
