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
    Scanner scanner = new Scanner(System.in);

//    Getter
    public String getCardHolderName(){ return CardHolderName; }
    public Date getCardExpiryDate(){ return CardExpiryDate; }
    public String getCardPAN(){ return CardPAN; }

//    Setter
    public boolean setCardHolderName(){
        System.out.print("Enter Card Holder Name: ");
        this.CardHolderName = scanner.nextLine();

        boolean result = this.CardHolderName.matches("[A-Za-z ]+");
        if (!result) {
            return false ;
        }

        return 20 <= this.CardHolderName.length() && this.CardHolderName.length() <= 24;
    }

    public boolean setCardExpiryDate(){
            System.out.print("Enter Card Expiry Date in the format 'MM/YY': ");
            String dataEntry = scanner.nextLine();

//        Card expiry date is 5 characters string in the format "MM/YY"
            if (dataEntry.matches("\\d{2}/\\d{2}") ) {
                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("MM/yy");
                    dateFormat.setLenient(false);
                    this.CardExpiryDate = dateFormat.parse(dataEntry);

                    return true;
                }
                catch (ParseException ex){
                    return false;
                }

            }
            return false;
    }

    public boolean setCardPAN(){
//        static String PAN_CARD_REGEX = "[A-Z]{S}[0-9](4)[A-Z](1)";
        System.out.print("Enter Your PAN: ");
        CardPAN = scanner.nextLine();

        return CardPAN.length() >= 16 && CardPAN.length() <= 19;

    }

}