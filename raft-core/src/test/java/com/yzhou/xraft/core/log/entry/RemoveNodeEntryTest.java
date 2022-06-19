package com.yzhou.xraft.core.log.entry;

import com.yzhou.xraft.core.node.NodeEndpoint;
import com.yzhou.xraft.core.node.NodeId;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;

public class RemoveNodeEntryTest {

    @Test
    public void getResultNodeEndpoints() {
        RemoveNodeEntry entry = new RemoveNodeEntry(1, 1,
                Collections.singleton(new NodeEndpoint("A", "localhost", 2333)), NodeId.of("A"));
        Assert.assertTrue(entry.getResultNodeEndpoints().isEmpty());
    }

}