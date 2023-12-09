package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Main {
    ICICI iciciBank = new ICICI();
    HDFC hdfcBank = new HDFC();
    SBI sbiBank = new SBI();
    AXIS axisBank = new AXIS();
    Map<ICICI, Integer> iciciCount = new HashMap();
    BufferedReader buff;
    InputStreamReader isr;

    public Main() {
        if (isr == null) // abhi to null h but agr baad me we dont know kha se input aara h so its good practice to keep checks
            isr = new InputStreamReader(System.in);  //take from Console
        if (buff == null)
            buff = new BufferedReader(isr); // convert to buffer ..streamline har baar ab yhi use honge jha bhi input lena hoga baar baar
        // streamreader aur buffered reader ke objects nhi bnane pdenge..
    }
    //CustomerName, customerEmail, customerAddress, customerGender, customerAadhar, customerPhone;

    public static void main(String[] args) {
        Map<String, Customer> ibsCustomerMap = new HashMap <>();
        Map<String, RBI> iciciCustomer  = new HashMap<>();
        Map<String, RBI> hdfcCustomer  = new HashMap<>();
        Map<String, RBI> sbiCustomer  = new HashMap<>();
        Map<String, RBI> axisCustomer  = new HashMap<>();
        RBI bank = null;
        Main obj = new Main();//only used for taking buffer nothing else..
        int enter = 0;
        while (true)
        {
            String aadhar = null;
            System.out.println("Welcome to IBS\nSelect one of the following: \n1. Select a bank 2. Exit the program");
            try {
                enter = Integer.parseInt(obj.buff.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(enter == 2)
                break;
            System.out.println("Enter your aadhar number\n");
            try {
                aadhar = obj.buff.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }


            //if(ibs.contains(aadhar)) implement map;
            if (!ibsCustomerMap.containsKey(aadhar)) {
                Customer cus = new Customer();
                System.out.print("You are a new customer.\nEnter your personal details...........\n");
                System.out.print("Enter your name: ");//name
                try {
                    cus.setCustomerName(obj.buff.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.print("Enter your email: ");//email
                try {
                    cus.setCustomerEmail(obj.buff.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.print("Enter your address: ");//address
                try {
                    cus.setCustomerAddress(obj.buff.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.print("Enter your Aadhar No.: ");//aadhar
                try {
                    cus.setCustomerAadhar(obj.buff.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.print("Enter your gender: ");//gender
                try {
                    cus.setCustomerGender(obj.buff.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.print("Enter your phone no.: ");//phone no.
                try {
                    cus.setCustomerPhone(obj.buff.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ibsCustomerMap.put(aadhar, cus);
            }
            else   //LOGGED IN TO IBS
            {
                while (true)
                {
                    int selectedBank = 0;
                    System.out.println("Hello user, you are logged into IBS\n");

                    System.out.println("Select one of the following\n1. ICICI\n2. HDFC\n3. SBI\n4. AXIS\n5.LOGOUT\n");
                    try {
                        selectedBank = Integer.parseInt(obj.buff.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    if (selectedBank == 5) {
                        System.out.println("Logging you out of IBS...\n");
                        break;
                    }
                    else//user selected a bank...
                    {
                        switch (selectedBank) {
                            case 1:
                                if(iciciCustomer.containsKey(aadhar))
                                {
                                    System.out.println("Hello" + aadhar + "you already have an a/c in ICICI Bank");
                                    bank = iciciCustomer.get(aadhar);
                                }
                                else
                                {
                                    bank = new ICICI();
                                    iciciCustomer.put(aadhar,bank);
                                }
                                System.out.println("Hello ICICI Customer :)" + aadhar);
                                break;
                            case 2:
                                if(hdfcCustomer.containsKey(aadhar))
                                {
                                    System.out.println("Hello" + aadhar + "you already have an a/c in HDFC Bank");
                                    bank = hdfcCustomer.get(aadhar);
                                }
                                else
                                {
                                    bank = new HDFC();
                                    hdfcCustomer.put(aadhar,bank);
                                }

                                System.out.println("Hello HDFC Customer :) " + aadhar);
                                break;
                            case 3:
                                if(sbiCustomer.containsKey(aadhar))
                                {
                                    System.out.println("Hello" + aadhar + "you already have an a/c in SBI Bank");
                                    bank = sbiCustomer.get(aadhar);
                                }
                                else
                                {
                                    bank = new SBI();
                                    sbiCustomer.put(aadhar, bank);
                                }
                                System.out.println("Hello SBI Customer :)\n");
                                break;
                            case 4:
                                if(axisCustomer.containsKey(aadhar))
                                {
                                    System.out.println("Hello" + aadhar + "you already have an a/c in AXIS Bank");
                                    bank = axisCustomer.get(aadhar);
                                }
                                else
                                {
                                    bank = new AXIS();
                                    axisCustomer.put(aadhar,bank);
                                }
                                System.out.println("Hello AXIS Customer :) \n");
                                break;
                            default: {
                                System.out.println("Invalid Choice\n");
                                break;
                            }
                        }
                        while (true) {
                            int selectedOperation = 0;
                            System.out.println("Select the operation\n1. Deposit\n2. Withdrawal\n3. OpenFD\n4. Apply Loan\n5. Apply CC\n6. See balance\n7. Exit this bank");
                            try {
                                selectedOperation = Integer.parseInt(obj.buff.readLine());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            if (selectedOperation == 7)
                                break;
                            switch (selectedOperation)
                            {
                                case 1:
                                    bank.depositMoney();
                                    System.out.println("Updated balance: " + bank.getBalance());
                                    break;
                                case 2:
                                    bank.withdrawMoney();
                                    System.out.println("Updated balance: " + bank.getBalance());
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
                                case 6:
                                    System.out.println(bank.getBalance());
                                    break;
                                default:
                                    System.out.println("Invalid operation number\n");
                            }
                        }
                    }
                }
            }
        }
    }
}