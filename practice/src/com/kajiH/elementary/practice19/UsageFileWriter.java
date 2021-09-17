package com.kajiH.elementary.practice19;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UsageFileWriter {
    static final Path DIR_PATH = Paths.get("C:\\tmp");
    static final Path FILE_PATH = Paths.get("C:\\tmp\\test.txt");
    static final String QUOTE_CURSOR = ">";
    static final LocalDateTime NOW = LocalDateTime.now();
    static List<String> lines = new ArrayList<>();

    public static void main(String[] args) {
        String name = "山本一郎";
        int usageContent = 5;

        // ディレクトリの存在確認
        if (Files.exists(DIR_PATH)) {
            showLogThatExistenceOf(DIR_PATH);
        } else {
            createDirectory(DIR_PATH);
        }

        // ファイルの存在確認
        if (Files.exists(FILE_PATH)) {
            showLogThatExistenceOf(FILE_PATH);
        } else {
            createFile(FILE_PATH);
        }

        makeLog(name, usageContent, lines);

        writeToFile(FILE_PATH, lines);

        List<String> readLines = readFile(FILE_PATH);

        showFileContents(readLines);
    }

    private static void showFileContents(List<String> readLines) {
        System.out.println("ファイル内容を表示します...");
        for (String line : readLines) {
            System.out.printf("%s %s %n", QUOTE_CURSOR, line);
        }
    }

    private static List<String> readFile(Path filePath) {
        List<String> readLines = new ArrayList<>();
        try {
            readLines = Files.readAllLines(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return readLines;
    }

    private static void writeToFile(Path filePath, List<String> lines2) {
        try {
            Files.write(filePath, lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void makeLog(String name, int usageContent, List<String> lines) {
        // 利用回数内容の作成
        lines.add("利用回数");
        lines.add("-----");
        // 利用日時の作成
        lines.add(String.format(" - 出力日時: %s-%s-%s(%s) %s:%s:%s", NOW.getYear(), NOW.getMonth(), NOW.getDayOfMonth(),
                NOW.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.JAPANESE), NOW.getHour(), NOW.getMinute(),
                NOW.getSecond()));
        // 詳細内容の作成
        lines.add(String.format(" - 氏名: %s", name));
        lines.add(String.format(" - 回数: %s", usageContent));
    }

    private static void createFile(Path filePath) {
        try {
            Files.createFile(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void showLogThatExistenceOf(Path dirPath) {
        System.out.printf("%s は既に存在します. %n", dirPath.toAbsolutePath().toString());
    }

    private static void createDirectory(Path dirPath) {
        try {
            Files.createDirectory(dirPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}