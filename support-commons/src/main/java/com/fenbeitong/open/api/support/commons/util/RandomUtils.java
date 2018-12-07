package com.fenbeitong.open.api.support.commons.util;

import org.apache.commons.lang3.RandomStringUtils;
import org.bson.types.ObjectId;

import java.security.SecureRandom;
import java.util.Date;
import java.util.UUID;

/**
 * RandomUtils
 *
 * <p>随即生成器
 *
 * @author ivan
 * @version 1.0 Created by ivan on 18-12-3 - 下午3:57.
 */
public class RandomUtils {
    private static final String NUMBER_CHAR = "0123456789";
    private static final String LETTER_CHAR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALL_CHAR =
            "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBER_LOWER_LETTER_CHAR = "0123456789abcdefghijklmnopqrstuvwxyz";
    private static SecureRandom random = new SecureRandom();

    public RandomUtils() {
    }

    public static String uuid() {
        return UUID.randomUUID().toString();
    }

    public static String uuidNoDelimiter() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String bsonId() {
        return ObjectId.get().toString();
    }

    public static String bsonId(Date date) {
        return date == null ? bsonId() : (new ObjectId(date)).toString();
    }

    public static int randomInt(int max) {
        return Math.abs(random.nextInt(max));
    }

    public static int randomInt(int min, int max) {
        return Math.abs(random.nextInt(max - min) + min);
    }

    public static String randomStr(int length) {
        return RandomStringUtils.randomAlphanumeric(length);
    }

    public static String randomNum(int length) {
        return RandomStringUtils.randomNumeric(length);
    }

    public static String randomLetter(int length) {
        return RandomStringUtils.randomAlphabetic(length);
    }

    public static String randomNumAndLowerLetter(int length) {
        if (length == 0) {
            return "";
        } else if (length < 0) {
            throw new IllegalArgumentException(
                    "Requested random string length " + length + " is less than 0.");
        } else {
            int len = "0123456789abcdefghijklmnopqrstuvwxyz".length();
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < length; ++i) {
                sb.append("0123456789abcdefghijklmnopqrstuvwxyz".charAt(randomInt(len)));
            }

            return sb.toString();
        }
    }
}
