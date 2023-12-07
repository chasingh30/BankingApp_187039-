package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    BufferedReader buff;
    InputStreamReader isr;
    public Main() {
        if(isr == null) // abhi to null h but agr baad me we dont know kha se input aara h so its good practice to keep checks
            isr = new InputStreamReader(System.in);  //take from Console
        if(buff==null)
            buff = new BufferedReader(isr); // convert to buffer ..streamline har baar ab yhi use honge jha bhi input lena hoga baar baar
                                            // streamreader aur buffered reader ke objects nhi bnane pdenge..
    }


    public static void main(String[] args) {
        RBI bank = null;
        int selectedBank = 0;
        Main obj = new Main();//only used for taking buffer nothing else..
        String choice = "yes";
        System.out.println("Welcome to IBS\nPlease select your bank\n1. ICICI\n2. HDFC\n3. SBI\n4. AXIS");
        try {
            selectedBank = Integer.parseInt(obj.buff.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Customer Selected " + selectedBank);
        while(choice == "yes") {

            switch(selectedBank)
            {
                case 1:
//                    bank = new ICICI();
//                    ICICI bank1 = (ICICI)bank;
//                    bank = bank1;
                    bank = new ICICI();
                    break;
                case 2:
                    bank = new HDFC();
                    break;
                case 3:
                    bank = new SBI();
                    break;
                case 4:
                    bank = new AXIS();
                    break;
            }
            System.out.println("Select the operation\n1. Deposit\n2. Withdrawal\n3. OpenFD\n4. Apply Loan\n5. Apply CC");
            int selectedOperation = 0;
            try {
               selectedOperation = Integer.parseInt(obj.buff.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Customer Selected " + selectedOperation);

            switch (selectedOperation) {
                case 1:
                    bank.depositMoney();
                    bank.getBalance();
                    break;
                case 2:
                    bank.withdrawMoney();
                    bank.getBalance();
                    break;
                case 3:
                    bank.openFD();
                    break;
                case 4:
                    bank.applyLoan();
                    break;
                case 5:
                    bank.applyCreditCard();
                    break;
                default:
                    System.out.println("Invalid operation number");
            }
            System.out.println("Do you want to proceed?");
            try {
                choice = obj.buff.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(choice == "no")
            {
                System.out.println("Welcome to IBS\nPlease select your bank\n1. ICICI\n2. HDFC\n3. SBI\n4. AXIS\n5. IDFC");
                try {
                    selectedBank = Integer.parseInt(obj.buff.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Customer Selected " + selectedBank);
                choice = "yes";
            }
        }
    }
}