package finki.emt.videomanagement.domain.valueobjects;

import finki.emt.sharedkernel.domain.base.ValueObject;
import lombok.Getter;

import javax.persistence.*;
import java.util.*;

@Embeddable
@Getter
public class Likes implements ValueObject {

    private  int likes;
    public Likes(){
        this.likes= 0;
    }

    public int increment(){

        return ++this.likes;
    }

    public int decrement(){
        return --this.likes;

    }
    public int count(){
        return this.likes;
    }
}
