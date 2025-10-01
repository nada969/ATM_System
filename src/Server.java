//        class Server(){
//          - Public validAmount ,Public amount ,Private balance
//          - isValidAccount()
//          - isAmountAvailable()
//          - updateAccountBalance()
//        }

import java.util.Date;
import java.util.Objects;

public class Server {

    boolean isValidAccount(String state){
        return "running".equalsIgnoreCase(state);
    }

    boolean isAmountAvailable(float amount,float balance ){
        return balance > amount ;
    }

}
