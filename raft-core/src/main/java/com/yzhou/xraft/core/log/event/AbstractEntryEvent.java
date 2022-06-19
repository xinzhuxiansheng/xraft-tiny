package com.yzhou.xraft.core.log.event;

import com.yzhou.xraft.core.log.entry.Entry;

abstract class AbstractEntryEvent<T extends Entry> {

    protected final T entry;

    AbstractEntryEvent(T entry) {
        this.entry = entry;
    }

    public T getEntry() {
        return entry;
    }

}
