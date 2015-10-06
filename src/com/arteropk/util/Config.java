package com.arteropk.util;

import java.io.File;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: Wasay
 * Date: 4/17/15
 * Time: 12:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class Config {

    private static final Random random = new Random();

    private static Map<String, String> map;

    static {
        map = init();
    }

    private Config() {
    }

    private static Map init()  {
        try {
            Map<String, String> map = new HashMap<>();
            final File file = new File("configs.txt");
            System.out.println(file.getAbsolutePath());
            List<String> lines = Files.readAllLines(file.toPath());
            for(final String s : lines) {
                final String[] parts = s.split("::");
                map.put(parts[0], parts[1]);
            }
            return map;
        }catch(Exception e) {
            e.printStackTrace();
            return new HashMap();
        }
    }


    public static String get(final String key) {
        return map.getOrDefault(key, key);

    }

    public static final String JAR_URL = get("jarurl");
    public static final String CLIENT = get("client");
    public static final boolean DVPK = true;



    public static String random() {
        char[] chars = new char[10];

        for(int i = 0; i < chars.length; i++) {
            chars[i] = (char)(65 + random(25));
        }
        return new String(chars);
    }

    public static int random(int range) {
        return random.nextInt(range + 1);
    }

}
