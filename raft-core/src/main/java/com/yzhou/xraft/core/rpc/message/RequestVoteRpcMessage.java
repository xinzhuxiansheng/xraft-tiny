package com.yzhou.xraft.core.rpc.message;

import com.yzhou.xraft.core.node.NodeId;
import com.yzhou.xraft.core.rpc.Channel;

public class RequestVoteRpcMessage extends AbstractRpcMessage<RequestVoteRpc> {

    public RequestVoteRpcMessage(RequestVoteRpc rpc, NodeId sourceNodeId, Channel channel) {
        super(rpc, sourceNodeId, channel);
    }

}
