package com.skynet.infrastructure;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class FileSensitiveWordsProvider implements SensitiveWordsProvider {

    private String filePath;

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public List<String> provide() throws Exception {
//        File file = ResourceUtils.getFile(filePath);
//        return Files.readAllLines(Paths.get(file.toURI()));
        return Collections.EMPTY_LIST;
    }
}
