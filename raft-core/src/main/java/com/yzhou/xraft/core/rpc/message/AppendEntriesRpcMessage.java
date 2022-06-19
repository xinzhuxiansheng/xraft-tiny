package com.yzhou.xraft.core.rpc.message;


import com.yzhou.xraft.core.node.NodeId;
import com.yzhou.xraft.core.rpc.Channel;

public class AppendEntriesRpcMessage extends AbstractRpcMessage<AppendEntriesRpc> {

    public AppendEntriesRpcMessage(AppendEntriesRpc rpc, NodeId sourceNodeId, Channel channel) {
        super(rpc, sourceNodeId, channel);
    }

}
