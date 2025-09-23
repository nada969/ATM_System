//        class Card(){
//          - private data[] = {name , date , PAN} /// array      Done
//          - getCardHolderName()                                 Done
//          - getCardExpiryDate()                                 Done
//          - getCardPAN()
//        }

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;


public class Card {
    private String CardHolderName;
    private Date CardExpiryDate;
    private String CardPAN;

//    Getter
    public String getCardHolderName(){ return CardHolderName; }
    public Date getCardExpiryDate(){ return CardExpiryDate; }
    public String getCardPAN(){ return CardPAN; }

//    Setter
    public boolean setCardHolderName(String name){

        this.CardHolderName = name;

        boolean result = this.CardHolderName.matches("[A-Za-z ]+");
        if (!result) {
            return false ;
        }

        return 20 <= this.CardHolderName.length() && this.CardHolderName.length() <= 24;
    }

    public boolean setCardExpiryDate(String date){


//        Card expiry date is 5 characters string in the format "MM/YY"
            if (date.matches("\\d{2}/\\d{2}") ) {
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yy");
                    dateFormat.setLenient(false);
                    this.CardExpiryDate = dateFormat.parse(date);

                    return true;
                }
                catch (ParseException ex){
                    return false;
                }

            }
            return false;
    }

    public boolean setCardPAN(String pan){
        CardPAN = pan;

        return CardPAN.length() >= 16 && CardPAN.length() <= 19;

    }

}