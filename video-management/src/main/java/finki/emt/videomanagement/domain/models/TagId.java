package finki.emt.videomanagement.domain.models;

import finki.emt.sharedkernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class TagId extends DomainObjectId {
    private TagId() {
        super(TagId.randomId(TagId.class).getId());
    }

    public TagId(@NonNull String uuid) {
        super(uuid);
    }

    public static TagId of(String uuid) {
        TagId p = new TagId(uuid);
        return p;
    }
}
