package org.sc.test.password.rules;

import java.util.List;

public interface Rule {

    void apply(String string, List<String> message);
}
