package finki.emt.videomanagement.domain.valueobjects;

import finki.emt.sharedkernel.domain.base.ValueObject;
import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Views implements ValueObject {
    private final int views;
    protected Views(){
        this.views=0;
    }
    protected Views(int val){
        this.views=val;
    }

    public Views increment(){

        return new Views(this.views+1);
    }
}
