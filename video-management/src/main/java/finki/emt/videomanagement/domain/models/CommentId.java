package finki.emt.videomanagement.domain.models;

import finki.emt.sharedkernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class CommentId extends DomainObjectId {
    private CommentId() {
        super(CommentId.randomId(CommentId.class).getId());
    }

    public CommentId(@NonNull String uuid) {
        super(uuid);
    }

    public static CommentId of(String uuid) {
        CommentId p = new CommentId(uuid);
        return p;
    }

}
