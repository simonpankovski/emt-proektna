package finki.emt.channelmanagement.domain.models;

import finki.emt.sharedkernel.domain.base.DomainObjectId;
import lombok.NonNull;

public class ChannelId extends DomainObjectId {
    private ChannelId() {
        super(ChannelId.randomId(ChannelId.class).getId());
    }

    public ChannelId(@NonNull String uuid) {
        super(uuid);
    }

    public static ChannelId of(String uuid) {
        ChannelId p = new ChannelId(uuid);
        return p;
    }
}
