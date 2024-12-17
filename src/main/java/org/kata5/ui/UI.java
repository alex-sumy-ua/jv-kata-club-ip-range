package org.kata5.ui;

import java.util.Scanner;

public class UI {

    private String startAddress;
    private String endAddress;

    public UI() {
        this.startAddress = "10.0.0.0";
        this.endAddress = "10.0.1.0";
    }

    public UI(String startAddress, String endAddress) {
        if (startAddress == null || startAddress.isEmpty()) {
            this.startAddress = "10.0.0.0";
        }
        else { this.startAddress = startAddress; }
        if (endAddress == null || endAddress.isEmpty()) {
            this.endAddress = "10.0.1.0";
        }
        else { this.endAddress = endAddress; }
    }

    public String getStartAddress() {
        return startAddress;
    }

    public void setStartAddress(String startAddress) {
        this.startAddress = startAddress;
    }

    public String getEndAddress() {
        return endAddress;
    }

    public void setEndAddress(String endAddress) {
        this.endAddress = endAddress;
    }

    public void handleUserInput() {
        Scanner scanner = new Scanner(System.in);
        String input;
        String regex = "\\b(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\." +
                       "(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\." +
                       "(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\." +
                       "(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\b";

        //        "\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b"; // simpler, without check <= 255

        System.out.println("""
                
                Please, type the start IP-address: """);

        while(true) {
            input = scanner.nextLine();
            if (input.matches(regex)) {
                setStartAddress(input);
                break;
            }
            System.out.println("Incorrect start IP-address. Try again:");
        }

        System.out.println("""
                
                Please, type the end IP-address: """);

        while(true) {
            input = scanner.nextLine();
            if (input.matches(regex)) {
                setEndAddress(input);
                break;
            }
            System.out.println("Incorrect end IP-address. Try again:");
        }

        System.out.println("Thank you! IP-addresses are " + getStartAddress() + " ; " + getEndAddress());
    }
}
