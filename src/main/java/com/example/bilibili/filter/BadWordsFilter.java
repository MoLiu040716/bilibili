package com.example.bilibili.filter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class BadWordsFilter {
    private static final String SENSITIVE_WORDS_FILE_PATH = "src/main/resources/BadWords.txt";

    private static String sensitiveWordsRegex;

    static {
        // 从文件加载敏感词汇并生成正则表达式
        sensitiveWordsRegex = loadSensitiveWordsRegex();
    }

    private static String loadSensitiveWordsRegex() {
        StringBuilder regexBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(SENSITIVE_WORDS_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // 将每一行的敏感词添加到正则表达式中
                regexBuilder.append(line.trim()).append("|");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 删除末尾的"|"
        if (regexBuilder.length() > 0) {
            regexBuilder.deleteCharAt(regexBuilder.length() - 1);
        }

        return regexBuilder.toString();
    }

    public static String filterComment(String comment) {
        // 进行敏感词过滤
        String filteredComment = filterSensitiveWords(comment);

        return filteredComment;
    }

    private static String filterSensitiveWords(String comment) {
        // 使用正则表达式替换敏感词汇为星号
        Pattern pattern = Pattern.compile(sensitiveWordsRegex);
        return pattern.matcher(comment).replaceAll("***");
    }

}
