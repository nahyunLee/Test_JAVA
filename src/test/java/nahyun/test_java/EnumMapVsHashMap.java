package com.wemakeprice;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class EnumMapTest {

    private final int TWO_BILLION = 2_000_000_000;

    @Test
    void enumMap_hashMap_String키로비교() {

        // hashMap
        Map<String, Integer> hashMap = new HashMap<>();

        long hashMapPutStarted = System.currentTimeMillis();
        for (int i = 0; i < TWO_BILLION; i++) {
            hashMap.put("nahyun", i);
        }
        long hashMapPutEnded = System.currentTimeMillis();

        long hashMapGetStarted = System.currentTimeMillis();
        for (int i = 0; i < TWO_BILLION; i++) {
            hashMap.get("nahyun");
        }
        long hashMapGetEnded = System.currentTimeMillis();


        //enumMap
        Map<EnumStringTest, Integer> enumMap = new EnumMap<>(EnumStringTest.class);
        long enumMapPutStarted = System.currentTimeMillis();
        for (int i = 0; i < TWO_BILLION; i++) {
            enumMap.put(EnumStringTest.NAHYUN, i);
        }
        long enumMapPutEnded = System.currentTimeMillis();

        long enumMapGetStarted = System.currentTimeMillis();
        for (int i = 0; i < TWO_BILLION; i++) {
            enumMap.get(EnumStringTest.NAHYUN);
        }
        long enumMapGetEnded = System.currentTimeMillis();


        System.out.println("hashMapStringPut = " + (hashMapPutEnded - hashMapPutStarted));
        System.out.println("enumMapStringPut = " + (enumMapPutEnded - enumMapPutStarted));
        /**
         * hashMapStringPut = 21027
         * enumMapStringPut = 8230
         */

        System.out.println("hashMapStringGet = " + (hashMapGetEnded - hashMapGetStarted));
        System.out.println("enumMapStringGet = " + (enumMapGetEnded - enumMapGetStarted));

        /**
         * hashMapStringGet = 4510
         * enumMapStringGet = 4
         */
    }

    @Test
    void enumMap_hashMap_Int키로비교() {

        Map<Integer, Integer> hashMap = new HashMap<>();

        long hashMapPutStarted = System.currentTimeMillis();
        for (int i = 0; i < TWO_BILLION; i++) {
            hashMap.put(22, i);
        }
        long hashMapPutEnded = System.currentTimeMillis();


        Map<EnumIntegerTest, Integer> enumMap = new EnumMap<>(EnumIntegerTest.class);
        long enumMapPutStarted = System.currentTimeMillis();
        for (int i = 0; i < TWO_BILLION; i++) {
            enumMap.put(EnumIntegerTest.TWOTWO, i);
        }
        long enumMapPutEnded = System.currentTimeMillis();


        System.out.println("hashMapIntegerPut = " + (hashMapPutEnded - hashMapPutStarted));
        System.out.println("enumMapIntegerPut = " + (enumMapPutEnded - enumMapPutStarted));
        /**
         * hashMapPut = 13817
         * enumMapPut = 6750
         */
    }

    private enum EnumStringTest {
        NAHYUN;
    }

    @RequiredArgsConstructor
    private enum EnumIntegerTest {
        TWOTWO(22);

        @Getter
        private final int raw;
    }
}
