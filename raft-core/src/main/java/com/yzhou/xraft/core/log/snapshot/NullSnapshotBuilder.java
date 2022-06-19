package com.yzhou.xraft.core.log.snapshot;

import com.yzhou.xraft.core.rpc.message.InstallSnapshotRpc;

public class NullSnapshotBuilder implements SnapshotBuilder {

    @Override
    public void append(InstallSnapshotRpc rpc) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Snapshot build() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void close() {
    }

}
