package com.yzhou.xraft.core.node.role;

import com.yzhou.xraft.core.schedule.ElectionTimeout;

import javax.annotation.concurrent.Immutable;

/**
 * @author yzhou
 * @date 2022/6/15
 */
@Immutable
public class CandidateNodeRole extends AbstractNodeRole {
    private final int votesCount; // 票数
    private final ElectionTimeout electionTimeout; // 选举超时

    // 构造函数，票数 1
    public CandidateNodeRole(int term, ElectionTimeout electionTimeout) {
        this(term, 1, electionTimeout);
    }

    public CandidateNodeRole(int term, int votesCount, ElectionTimeout electionTimeout) {
        super(RoleName.CANDIDATE, term);
        this.votesCount = votesCount;
        this.electionTimeout = electionTimeout;
    }

    // 获取投票数
    public int getVotesCount() {
        return votesCount;
    }

    @Override
    public void cancelTimeoutOrTask() {
        electionTimeout.cancel();
    }

    @Override
    public String toString() {
        return "CandidateNodeRole{" +
                "term=" + term +
                ", votesCount=" + votesCount +
                ", electionTimeout=" + electionTimeout +
                '}';
    }
}
