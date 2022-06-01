/* Copyright © 2020 EIS Group and/or one of its affiliates. All rights reserved. Unpublished work under U.S. copyright laws.
CONFIDENTIAL AND TRADE SECRET INFORMATION. No portion of this work may be copied, distributed, modified, or incorporated into any other media without EIS Group prior written consent.*/

package homework1;

public class CalculatorMain {

    public static void main(String[] args) {
        do {
            System.out.println(Calculator.calculateOperation());
        } while (Calculator.isTurnOffCalculator());
    }
}
