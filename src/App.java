import java.util.Date;
import java.util.Scanner;

public class App {

    public String CardHolderName;
    public Date CardExpiryDate;
    public String CardPAN;
    public float TransactionAmount;

    Scanner scanner = new Scanner(System.in);

    Card client1 = new Card();
    Terminal terminal1 = new Terminal();
    Server server1 = new Server();
    PostgresConnect db = new PostgresConnect();


    public String register(){

        //Get card data

//           Name
        System.out.print("Enter Card Holder Name: ");
        String name = scanner.nextLine();
        if (client1.setCardHolderName(name)) {
            this.CardHolderName = client1.getCardHolderName();
        }
        else { return "wrong name entry"; }
//           Expire date
        System.out.print("Enter Card Expiry Date in the format 'MM/YY': ");
        String expiryDate = scanner.nextLine();
        if (client1.setCardExpiryDate(expiryDate)) {
            this.CardExpiryDate = client1.getCardExpiryDate();
        }
        else { return "wrong date"; }
//           PAN
        System.out.print("Enter Card PAN: ");
        String pan = scanner.nextLine();
        if (client1.setCardPAN(pan)) {
            this.CardPAN = client1.getCardPAN();

        }
        else { return "wrong PAN"; }

//        connect to DB
//        save this new client in DB with default balance=5000LE:
        db.connect();
        db.updateDB(this.CardHolderName,"Running",5000);
        System.out.println(db.getStatus(this.CardHolderName));
        return "Registration Done";

    }

    public String login() {

//        get the TransactionAmount
        if (!terminal1.isCardExpired(client1)) {

            System.out.print("Enter your transaction amount: ");
            float amount = scanner.nextFloat();
            terminal1.setTransactionAmount(amount);

            if (!terminal1.isExceededAmount()) {
                this.TransactionAmount = terminal1.getTransactionAmount();
            }
            else { return "Exceed Max Amount"; }
        }
        else { return "Card Expired"; }

//        connect to DB

        db.connect();
        String state = db.getStatus(this.CardHolderName);
        if(server1.isValidAccount(state)){
            float balance = db.getBalance(this.CardHolderName);
            if(server1.isAmountAvailable(this.TransactionAmount,balance)){
                float res = balance - this.TransactionAmount;
                db.updateAccountBalance(this.CardHolderName,res);
                return this.CardHolderName + "has login successfully and the updated balance= "+res;
            }
            else {return "No available amount";}
        }
        else{return "this account is Blocked";}







    }

}
