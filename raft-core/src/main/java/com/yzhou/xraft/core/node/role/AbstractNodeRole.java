package com.yzhou.xraft.core.node.role;

/**
 * @author yzhou
 * @date 2022/6/14
 */
abstract class AbstractNodeRole {
    private final RoleName name;
    protected final int term;

    public AbstractNodeRole(RoleName name, int term) {
        this.name = name;
        this.term = term;
    }

    // 获取当前的角色名
    public RoleName getName() {
        return name;
    }

    // 取消超时或者定时任务
    public abstract void cancelTimeoutOrTask();

    // 获取当前的term
    public int getTerm() {
        return term;
    }
}
