package finki.emt.videomanagement.domain.valueobjects;

import finki.emt.sharedkernel.domain.base.ValueObject;
import lombok.Getter;

import javax.persistence.*;
import java.util.*;

@Embeddable
@Getter
public class Dislikes implements ValueObject {

    private int dislikes;
    public Dislikes(){
        this.dislikes= 0;
    }

    public int increment(){

        return ++this.dislikes;
    }

    public int decrement(){
        return --this.dislikes;

    }
    public int count(){
        return this.dislikes;
    }
}
