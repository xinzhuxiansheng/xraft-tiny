package com.yzhou.xraft.core.log.event;

import com.yzhou.xraft.core.log.entry.GroupConfigEntry;

public class GroupConfigEntryCommittedEvent extends AbstractEntryEvent<GroupConfigEntry> {

    public GroupConfigEntryCommittedEvent(GroupConfigEntry entry) {
        super(entry);
    }

}
