package com.yzhou.xraft.core.node.task;

import com.yzhou.xraft.core.node.NodeId;

import java.util.concurrent.Callable;

public interface GroupConfigChangeTask extends Callable<GroupConfigChangeTaskResult> {

    GroupConfigChangeTask NONE = new NullGroupConfigChangeTask();

    boolean isTargetNode(NodeId nodeId);

    void onLogCommitted();

}
