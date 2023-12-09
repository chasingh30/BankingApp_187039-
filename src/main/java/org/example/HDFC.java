package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class HDFC implements RBI {
    float minBalance = 2000.0f;
    float balance = 4000.0f,fdBalance = 0.0f;
    BufferedReader buff;
    InputStreamReader isr;
    public HDFC()
    {
        if(isr == null)
            isr = new InputStreamReader(System.in);
        if(buff==null)
            buff = new BufferedReader(isr);
    }


    @Override
    public void depositMoney() {
        float money = 0.0f;
        System.out.println("Enter the amount to deposit : ");
        try {
            money = Float.parseFloat(buff.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        balance += money;
    }
    @Override
    public void withdrawMoney(){
        float withdraw = 0.0f;
        int countWithdrawal = 0;
        countWithdrawal++;
        System.out.println("Enter the amount u want to withdraw: ");
        try {
            withdraw = Float.parseFloat(buff.readLine());
            if (countWithdrawal > 3)
                withdraw += (withdraw / 100);
        } catch (IOException e) {
            e.printStackTrace();
        }
        balance -= withdraw;
    }
    @Override
    public void openFD()
    {
        float principal = 0.0f, ROI = 0.05f;
        int time = 0;
        System.out.println("Enter deposit amount for FD: ");
        try {
            principal = Float.parseFloat(buff.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Enter FD tenure: ");
        try {
            time = Integer.parseInt(buff.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i = 0;i<time;i++)
        {
            principal += (principal*ROI)/100;
        }
        fdBalance = principal;
        System.out.println("Matured FD Balance is : " +fdBalance);
    }
    @Override
    public void applyLoan() {//APPLY P*R*T)/100 AND give 1% to RBI;
        if(balance <= 2*minBalance)
            System.out.println("Non-eligible for loan\nMinimum balance required to open the account: "+(2*minBalance));
        else //eligible for loan;
        {
            int loanType = 0;
            float ROI = .05f, amount = 0.0f; //5%
            int years = 0;
            System.out.println("Enter loan type\n1. home\n2. education\n3. personal\n4. car\n");
            try {
                loanType = Integer.parseInt(buff.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch (loanType) {
                case 1:
                    ROI = 0.05f;
                    break;
                case 2:
                    ROI = 0.03f;
                    break;
                case 3:
                    ROI = 0.06f;
                    break;
                case 4:
                    ROI = 0.08f;
                    break;
            }

            System.out.println("Enter loan amount u want to take: ");
            try {
                amount = Float.parseFloat(buff.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            System.out.println("Enter tenure: ");
            try {
                years = Integer.parseInt(buff.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }

            float interest = amount * ROI * (float) years;
            float rbiPay = loanROI * interest;
            System.out.println("Amount payable to rbi = " + rbiPay);
        }
    }
    @Override
    public void applyCreditCard() {
        if(balance <= 2*minBalance)
            System.out.println("Not eligible for Credit Card");
        else
        {
            float amount = 0.0f;
            System.out.println("Enter CC amount: ");
            try {
                amount = Float.parseFloat(buff.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            float ROI = 0.1f;//10 percent
            float payAmount = amount+(ROI*amount);
            balance += amount;
            float rbiPay = ccROI * (payAmount-amount);
            System.out.println("Credit Card Issued \nUpdated balance = " + getBalance());
            System.out.println("Amount payable by user at the end of month: "+payAmount);
            System.out.println("Amount payable to rbi = " + rbiPay);
        }
    }
    @Override
    public float getBalance() {
        return balance;
    }
}
