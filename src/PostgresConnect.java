import java.sql.*;
import java.text.BreakIterator;


public class PostgresConnect {

    public Connection conn;
//               connect DB
    public void connect() {
        String url = "jdbc:postgresql://localhost:5432/ATM System";
        String user = "postgres";                                    // PostgreSQL username
        String password = "493075273";                               // PostgreSQL password

        try {
            // Connect to PostgreSQL
            Connection conn = DriverManager.getConnection(url, user, password);
//            System.out.println("Connected to PostgreSQL successfully!");

            this.conn = conn;
//            conn.close();

        } catch (Exception e) {
            System.out.println("exceptionnnnnnnnnn");
        }


    }

//                 get connection from DB
    public String getStatus(String name){

        String query = "Select status from cutomers_DB where CardHolderName = ?";
        try (PreparedStatement pstm = this.conn.prepareStatement(query)){
            pstm.setString(1,name);
            ResultSet resultState = pstm.executeQuery();

            if(resultState.next()) {
                return resultState.getString("status");
            }else {
                return "No record found for :" +name;
            }
        }
        catch (Exception e){
            return e.toString();
        }
    }

//                 get Balance from DB
    public float getBalance(String name ){
        String query = "Select balance from cutomers_DB where CardHolderName = ?";
        try (PreparedStatement pstm = this.conn.prepareStatement(query)){
            pstm.setString(1,name);
            ResultSet resultSet = pstm.executeQuery();
            if(resultSet.next()){
                return resultSet.getFloat("balance");
            }
            else {
                return 0;
            }
        }
        catch (Exception e){
            return 0;
        }
    }

//                 update Balance in DB
    public void updateAccountBalance(String name,float amount){
        String query = "Update cutomers_DB Set balance=? where CardHolderName = ?";
        try (PreparedStatement pstm = this.conn.prepareStatement(query)){
            pstm.setString(2,name);
            pstm.setFloat(1,amount);
            pstm.executeUpdate();                                 ////////update in DB
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }

//    insert new client( new row ) in DB
    public void updateDB(String name, String status, float balance){
        String query = "Insert into cutomers_DB (CardHolderName,status,balance) values (?,?,?)";
        try (PreparedStatement pstm = this.conn.prepareStatement(query)){
            pstm.setString(1,name);
            pstm.setString(2,status);
            pstm.setFloat(3,balance);
            pstm.executeUpdate();                            ////////insert new row in DB
        }catch (Exception e){
            System.out.println("New record is not valid because: " + e.toString());
        }
    }

}

