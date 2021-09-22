package finki.emt.videomanagement.domain.valueobjects;

import finki.emt.sharedkernel.domain.base.ValueObject;
import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Length implements ValueObject {
    private final double seconds;
    protected Length(){
        this.seconds = 0;
    }
    public double toMinutes(){
        return Math.floor(this.seconds/60);
    }
    public double toHours(){

        return Math.floor(Math.floor(this.seconds/60)/60);

    }
}
