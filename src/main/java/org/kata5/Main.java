package org.kata5;

import org.kata5.logic.Calculation;
import org.kata5.ui.UI;

public class Main {

    public static void main(String[] args) {

//        System.out.println(countAddresses("10.0.0.0", "10.0.0.50")); // Output: 50
//        System.out.println(countAddresses("10.0.0.0", "10.0.1.0"));  // Output: 256
//        System.out.println(countAddresses("20.0.0.10", "20.0.1.0")); // Output: 246

        UI view = new UI();
        view.handleUserInput();

        String startIP = view.getStartAddress();
        String endIP = view.getEndAddress();

        Calculation calculation = new Calculation(startIP, endIP);
        calculation.printResult();

    }

}