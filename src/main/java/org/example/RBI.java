package org.example;


interface RBI {
//    float balance = 0.0f, fdBalance = 0.0f;
    float loanROI = 0.01f,ccROI = 0.0f;
    void depositMoney() ;
    void withdrawMoney();
    void openFD();
    void applyLoan() ;
    void applyCreditCard() ;
    float getBalance() ;
}

//public class RBI
// {
//    float balance,fdBalance;
//
//    public RBI()
//    {
//        balance = 2000.2f;
//    }
//    public void depositMoney(float money) {
//        balance += money;
//    }
//    public void withdrawMoney(float money){
//        balance -= money;
//    }
//    public void openFD(float amount, float ROI, int years)
//    {
//        fdBalance = amount;
//        for(int i = 0;i<years;i++)
//        {
//            fdBalance += (fdBalance*ROI)/100;
//        }
//        System.out.println("Matured FD Balance is : " +fdBalance);
//    }
//    public void applyLoan(String loanType, float amount, float ROI, int years) {
//        System.out.println(amount*ROI*(float)years/100);
//    }
//    public void applyCreditCard() {}
//    public float getBalance() {
//        return balance;
//    }
//}