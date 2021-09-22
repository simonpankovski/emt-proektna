package finki.emt.videomanagement.domain.valueobjects;

import finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;
@Embeddable
public class UserId extends DomainObjectId {

    private UserId() {
        super(UserId.randomId(UserId.class).getId());
    }

    public UserId(String uuid) {
        super(uuid);
    }

}
