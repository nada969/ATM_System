import java.util.Date;
import java.util.Scanner;

public class App {

    public String CardHolderName;
    public Date CardExpiryDate;
    public String CardPAN;
    public float TransactionAmount;

    public String app() {
        Scanner scanner = new Scanner(System.in);

        //Get card data
        Card client1 = new Card();
        Terminal terminal1 = new Terminal();

        System.out.print("Enter Card Holder Name: ");
        String name = scanner.nextLine();
        if (client1.setCardHolderName(name)) {
            this.CardHolderName = client1.getCardHolderName();
        }
        else { return "wrong name entry"; }

        System.out.print("Enter Card Expiry Date in the format 'MM/YY': ");
        String expiryDate = scanner.nextLine();
        if (client1.setCardExpiryDate(expiryDate)) {
            this.CardExpiryDate = client1.getCardExpiryDate();
        }
        else { return "wrong date"; }

        System.out.print("Enter Card PAN: ");
        String pan = scanner.nextLine();
        if (client1.setCardPAN(pan)) {
            this.CardPAN = client1.getCardPAN();
        }
        else { return "wrong PAN"; }

        if (!terminal1.isCardExpired(client1)) {

            System.out.print("Enter your transaction amount: ");
            float amount = scanner.nextFloat();

            if (!terminal1.isExceededAmount()) {
                this.TransactionAmount = terminal1.getTransactionAmount();
            }
            else { return "Exceed Max Amount"; }
        }
        else { return "Card Expired"; }


//        save [this.CardHolderName ,  this.CardExpiryDate , this.CardPAN , this.TransactionAmount (not this I want tosave balance) ] in the clients_DB


        return this.CardHolderName;
    }

}
