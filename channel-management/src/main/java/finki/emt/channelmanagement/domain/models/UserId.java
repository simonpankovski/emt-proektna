package finki.emt.channelmanagement.domain.models;

import finki.emt.sharedkernel.domain.base.DomainObjectId;
import lombok.NonNull;

import javax.persistence.Embeddable;


public class UserId extends DomainObjectId {
    private UserId() {
        super(UserId.randomId(UserId.class).getId());
    }

    public UserId(@NonNull String uuid) {
        super(uuid);
    }

    public static UserId of(String uuid) {
        UserId p = new UserId(uuid);
        return p;
    }
}
