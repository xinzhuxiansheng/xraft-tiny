package com.yzhou.xraft.core.log.event;

import com.yzhou.xraft.core.log.entry.GroupConfigEntry;

public class GroupConfigEntryFromLeaderAppendEvent extends AbstractEntryEvent<GroupConfigEntry> {

    public GroupConfigEntryFromLeaderAppendEvent(GroupConfigEntry entry) {
        super(entry);
    }

}
