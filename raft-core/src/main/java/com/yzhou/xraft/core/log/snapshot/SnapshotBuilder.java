package com.yzhou.xraft.core.log.snapshot;

import com.yzhou.xraft.core.rpc.message.InstallSnapshotRpc;

public interface SnapshotBuilder<T extends Snapshot> {

    void append(InstallSnapshotRpc rpc);

    T build();

    void close();

}
