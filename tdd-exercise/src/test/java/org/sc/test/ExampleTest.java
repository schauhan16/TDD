package org.sc.test;

import java.util.HashMap;
import java.util.Map;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ExampleTest {

    @Test
    void testComputeIfAbsentTest() {

        final Map<String, String> testMap = new HashMap<>();

        Assertions.assertThat(testMap.computeIfAbsent("test", s -> testMap.put(s, "testString")))
                .isEqualTo("testString");

    }
}
