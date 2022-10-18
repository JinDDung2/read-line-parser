package com.line.connection;

import java.util.Map;

public class ConnectionConst {

    public static Map<String, String> env = System.getenv();
    public static String dbHost = env.get("DB_HOST");
    public static String dbUser = env.get("DB_USER");
    public static String dbPassword = env.get("DB_PASSWORD");


}
