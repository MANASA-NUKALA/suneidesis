package com.harium.suneidesis.knowledge.inspector.matchers;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;

public class EqualsTest {

    @Test
    public void testEvaluate() {
        Equals matcher = new Equals(new BigDecimal("1"));
        assertTrue(matcher.evaluate("1"));
    }

}
