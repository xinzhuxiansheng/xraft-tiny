package com.yzhou.xraft.core.service;

import com.yzhou.xraft.core.node.NodeId;

public class RedirectException extends ChannelException {

    private final NodeId leaderId;

    public RedirectException(NodeId leaderId) {
        this.leaderId = leaderId;
    }

    public NodeId getLeaderId() {
        return leaderId;
    }

}
