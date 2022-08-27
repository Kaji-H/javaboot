package com.kajih.practice07;

public class Logger {
    public enum LogType {
        DEBUG("DEBUG"),
        INFO("INFO"),
        WARN("WARN"),
        ERROR("ERROR");

        private String name;

        private LogType(String name) {
            this.name = name;
        }

        private String getName() {
            return this.name;
        }
    }

    public static void log(LogType type, String string) {
        System.out.format(
                ":: [%s] %s %n", type.getName(), string);
    }

    public static void log(LogType type, Exception e) {
        log(type, e.getMessage());
        log(type, e.getClass().getName());
        for (StackTraceElement element : e.getStackTrace()) {
            log(type, "  at " + element.toString());
        }
    }
}
