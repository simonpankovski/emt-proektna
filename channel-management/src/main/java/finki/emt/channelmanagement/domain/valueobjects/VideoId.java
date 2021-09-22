package finki.emt.channelmanagement.domain.valueobjects;

import finki.emt.sharedkernel.domain.base.DomainObjectId;

import javax.persistence.Embeddable;
@Embeddable
public class VideoId extends DomainObjectId {

    private VideoId() {
        super(VideoId.randomId(VideoId.class).getId());
    }

    public VideoId(String uuid) {
        super(uuid);
    }

}