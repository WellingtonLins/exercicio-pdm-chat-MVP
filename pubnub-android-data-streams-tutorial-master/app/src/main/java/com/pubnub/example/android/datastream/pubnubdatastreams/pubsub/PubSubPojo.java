package com.pubnub.example.android.datastream.pubnubdatastreams.pubsub;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class PubSubPojo {
    private final String sender;
    private final String message;

    public PubSubPojo(@JsonProperty("sender") String sender, @JsonProperty("message") String message) {
        this.sender = sender;
        this.message = message;
    }

    public String getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        final PubSubPojo other = (PubSubPojo) obj;

        return Objects.equal(this.sender, other.sender)
                && Objects.equal(this.message, other.message);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(sender, message);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(PubSubPojo.class)
                .add("sender", sender)
                .add("message", message)
                .toString();
    }
}
