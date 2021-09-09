package com.skynet.infrastructure;

import java.util.List;

public interface SensitiveWordsProvider {
    List<String> provide() throws Exception;
}
