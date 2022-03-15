package com.ehizman.drones.util;

import java.util.Random;

public class Commons {
    public static String generateId(){
        int value = Math.abs(new Random().nextInt() * 1000000);
        return String.format("%07d", value);
    }
}
