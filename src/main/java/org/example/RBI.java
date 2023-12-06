package org.example;

public class RBI {
    float balance,fdBalance;

    public RBI()
    {
        balance = 2000.2f;
    }
    public void depositMoney(float money) {
        balance += money;
    }
    public void withdrawMoney(float money){
        balance -= money;
    }
    public void openFD(float amount, float ROI, int years)
    {
        fdBalance = amount;
        for(int i = 0;i<years;i++)
        {
            fdBalance += (fdBalance*ROI)/100;
        }
        System.out.println("Matured FD Balance is : " +fdBalance);
    }
    public void applyLoan(String loanType, float amount, float ROI, int years) {
        System.out.println(amount*ROI*(float)years/100);
    }
    public void applyCreditCard() {}
    public float getBalance() {
        return balance;
    }
}