package org.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    int selectedBank, selectedOperation;
    float deposit,withdraw,fdAmount;

    int fdYears;
    BufferedReader buff;
    InputStreamReader isr;
    RBI rbi;
    int countWithdrawal;
    public Main() {
        rbi = new RBI();
        countWithdrawal = 0;
        if(isr == null) // abhi to null h but agr baad me we dont know kha se input aara h so its good practice to keep checks
            isr = new InputStreamReader(System.in);  //take from Console
        if(buff==null)
            buff = new BufferedReader(isr); // convert to buffer ..streamline har baar ab yhi use honge jha bhi input lena hoga baar baar
                                            // streamreader aur buffered reader ke objects nhi bnane pdenge..
    }


    public static void main(String[] args) {
        Main obj = new Main();
        System.out.println("Welcome to IBS\nPlease select your bank\n1. ICICI\n2. HDFC\n3. SBI\n4. AXIS\n5. IDFC");
//        obj.selectedBank = Integer.parseInt(obj.buff.readLine());
        try {
            obj.selectedBank = Integer.parseInt(obj.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Customer Selected " + obj.selectedBank);
        System.out.println("Select your choice\n1. Deposit\n2. Withdrawal\n3. OpenFD\n4. Apply Loan\n5. Apply CC");

        try {
            obj.selectedOperation = Integer.parseInt(obj.buff.readLine());
        }
        catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Customer Selected " + obj.selectedOperation);

        switch(obj.selectedOperation)
        {
            case 1:
                System.out.println("Enter the amount to deposit : ");
                try{
                    obj.deposit = Float.parseFloat(obj.buff.readLine());
                    obj.rbi.depositMoney(obj.deposit);
                    System.out.println(obj.rbi.getBalance());
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                break;
            case 2:
                obj.countWithdrawal++;
                try{
                    obj.withdraw = Float.parseFloat(obj.buff.readLine());
                    if(obj.countWithdrawal <= 3)
                        obj.rbi.withdrawMoney(obj.withdraw);
                    else
                        obj.rbi.withdrawMoney(obj.withdraw + (obj.withdraw/100));
                    System.out.println(obj.rbi.getBalance());
                }
                catch(IOException e)
                {
                    e.printStackTrace();
                }
                break;
            case 3:

                System.out.println("Enter deposit amount for FD: ");
                try{
                    obj.fdAmount = Float.parseFloat(obj.buff.readLine());
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Enter FD tenure: ");
                try{
                    obj.fdYears = Integer.parseInt(obj.buff.readLine());
                }
                catch(IOException e) {
                    e.printStackTrace();
                }
                obj.rbi.openFD(obj.fdAmount,6,obj.fdYears);
                break;
            case 4:
                obj.rbi.applyLoan("home", 1000000, 5, 2);
                break;
        }
    }
}