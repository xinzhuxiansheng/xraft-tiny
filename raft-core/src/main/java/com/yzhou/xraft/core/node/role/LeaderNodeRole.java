package com.yzhou.xraft.core.node.role;

import javax.annotation.concurrent.Immutable;

/**
 * @author yzhou
 * @date 2022/6/15
 */
@Immutable
public class LeaderNodeRole extends AbstractNodeRole{
    private final LogReplicationTask logReplicationTask; //日志复制定时器

    public LeaderNodeRole(int term, LogReplicationTask logReplicationTask) {
        super(RoleName.LEADER, term);
        this.logReplicationTask = logReplicationTask;
    }

    @Override
    public void cancelTimeoutOrTask() {
        logReplicationTask.cancel();
    }

    @Override
    public String toString() {
        return "LeaderNodeRole{" +
                "term=" + term +
                ", logReplicationTask=" + logReplicationTask +
                '}';
    }
}
