package finki.emt.videomanagement.domain.models;

import finki.emt.sharedkernel.domain.base.AbstractEntity;
import lombok.Getter;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity
@Table(name = "tag")
@Getter
public class Tag extends AbstractEntity<TagId> {

    private final String name;

    protected Tag(){
        super(TagId.randomId(TagId.class));
        this.name = "";

    }
    public Tag(String name){
        super(TagId.randomId(TagId.class));
        this.name = name;

    }
    public Tag(String name, Set<Video> videos){
        super(TagId.randomId(TagId.class));
        this.name = name;

    }


}
