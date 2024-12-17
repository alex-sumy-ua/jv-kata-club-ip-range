package org.kata5;

public class Main {

    public static void main(String[] args) {

        System.out.println(countAddresses("10.0.0.0", "10.0.0.50")); // Output: 50
        System.out.println(countAddresses("10.0.0.0", "10.0.1.0"));  // Output: 256
        System.out.println(countAddresses("20.0.0.10", "20.0.1.0")); // Output: 246

    }

    public static long countAddresses(String startIP, String endIP) {
        long start = ipToLong(startIP);
        long end = ipToLong(endIP);
        return end - start;
    }

    public static long ipToLong(String ipAddress) {
        String[] octets = ipAddress.split("\\."); // Split by "."
        long result = 0;

        for (int i = 0; i < 4; i++) {
            result = (result << 8) + Integer.parseInt(octets[i]);
        }

        return result;
    }

}