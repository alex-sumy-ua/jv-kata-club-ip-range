package org.kata5.logic;

public class Calculation {

    private String startIP;
    private String endIP;

    public Calculation(String startIP, String endIP) {
        this.startIP = startIP;
        this.endIP = endIP;
    }

    // COLOURS ****************************************************************
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    // ************************************************************************

    public static long countAddresses(String startIP, String endIP) {
        long start = ipToLong(startIP);
        long end = ipToLong(endIP);
        return end - start;
    }

    public static long ipToLong(@org.jetbrains.annotations.NotNull String ipAddress) {
        String[] octets = ipAddress.split("\\."); // Split by "."
        long result = 0;

        for (int i = 0; i < 4; i++) {
            result = (result << 8) + Integer.parseInt(octets[i]); // the same as multiplying result by 256 (2⁸)
        }

        return result;
    }

    public void printResult() {
        System.out.println(ANSI_RED +
                           "\n" +
                           "The IP-range includes the number of addresses: " + countAddresses(startIP, endIP) +
                           ANSI_RESET);
    }

}
