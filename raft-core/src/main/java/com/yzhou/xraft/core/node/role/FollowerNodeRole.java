package com.yzhou.xraft.core.node.role;

import com.yzhou.xraft.core.schedule.ElectionTimeout;

import javax.annotation.concurrent.Immutable;

/**
 * @author yzhou
 * @date 2022/6/14
 */
@Immutable
public class FollowerNodeRole extends AbstractNodeRole {
    private final NodeId votedFor; // 投过票的节点，有可能为空
    private final NodeId leaderId; // 当前leader节点ID，有可能为空
    private final ElectionTimeout electionTimeout; // 选举超时

    public FollowerNodeRole(int term, NodeId votedFor, NodeId leaderId, ElectionTimeout electionTimeout) {
        super(RoleName.FOLLOWER, term);
        this.votedFor = votedFor;
        this.leaderId = leaderId;
        this.electionTimeout = electionTimeout;
    }

    // 获取投过票的节点
    public NodeId getVotedFor() {
        return votedFor;
    }

    // 获取当前leader节点ID
    public NodeId getLeaderId(){
        return leaderId;
    }

    // 取消选举定时器
    @Override
    public void cancelTimeoutOrTask() {
        electionTimeout.cancel();
    }

    @Override
    public String toString() {
        return "FollowerNodeRole{" +
                "votedFor=" + votedFor +
                ", leaderId=" + leaderId +
                ", electionTimeout=" + electionTimeout +
                '}';
    }
}
