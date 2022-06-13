package com.yzhou.xraft.core.node.role;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;

import javax.annotation.Nonnull;
import javax.annotation.concurrent.Immutable;
import java.io.Serializable;

/**
 * @author yzhou
 * @date 2022/6/14
 */
@Immutable
public class NodeId implements Serializable {
    private final String value;

    public NodeId(@Nonnull String value) {
        Preconditions.checkNotNull(value);
        this.value = value;
    }

    public static NodeId of(@Nonnull String value) {
        return new NodeId(value);
    }

    @Nonnull
    public String getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof NodeId)) return false;
        NodeId id = (NodeId) obj;
        return Objects.equal(value, id.value);
    }

    @Override
    public String toString() {
        return this.value;
    }
}
