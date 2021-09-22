package finki.emt.videomanagement.domain.models;

import finki.emt.sharedkernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class VideoId extends DomainObjectId {
    private VideoId() {
        super(VideoId.randomId(VideoId.class).getId());
    }

    public VideoId(@NonNull String uuid) {
        super(uuid);
    }

    public static VideoId of(String uuid) {
        VideoId p = new VideoId(uuid);
        return p;
    }

}
