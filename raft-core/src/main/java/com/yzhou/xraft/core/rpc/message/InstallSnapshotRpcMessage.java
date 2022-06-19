package com.yzhou.xraft.core.rpc.message;

import com.yzhou.xraft.core.node.NodeId;
import com.yzhou.xraft.core.rpc.Channel;

import javax.annotation.Nullable;

public class InstallSnapshotRpcMessage extends AbstractRpcMessage<InstallSnapshotRpc> {

    public InstallSnapshotRpcMessage(InstallSnapshotRpc rpc, NodeId sourceNodeId, @Nullable Channel channel) {
        super(rpc, sourceNodeId, channel);
    }

}
