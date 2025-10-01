//        class Terminal(){
//          - data[] , Public dateToDay ,Private dateExpired , Public amount , Public maxAmount
//          - getTransactionDate()                  Done
//          - isCardExpired()                       Done
//          - getTransactionAmount()                Done
//          - isExceededAmount()                    Done
//        }

import java.util.Date;



public class Terminal {

    private float transAmount;
    private float maxTransAmount= 1000;
    private Date transactionDate;

    public Date getTransactionDate(){
        this.transactionDate = new Date();
        return this.transactionDate;
    }

    // Check if card is expired
    public boolean isCardExpired(Card c){

        Date today = this.getTransactionDate();
        Date expireDate = c.getCardExpiryDate();

        return expireDate.before(today);   // if true: it's expired
    }

    public void setTransactionAmount( float amount){
        this.transAmount = amount;
    }

    public float getTransactionAmount(){
        return this.transAmount;
    }

    // Check if transaction exceeds max allowed
    public boolean isExceededAmount(){
        return this.transAmount > this.maxTransAmount;   // if true it's actual exceed

    }
}

