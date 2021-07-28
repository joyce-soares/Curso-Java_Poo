package application;

import db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "INSERT INTO seller" +
                    "(Name, Email, BirthDate, BaseSalary, DepartmentId)" +
                    "VALUES " +
                    "(?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, "Joyce Soares");
            st.setString(2, "joyce@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("22/07/1996").getTime()));
            st.setDouble(4, 5000.0);
            st.setInt(5, 4);

            int rowsAffected = st.executeUpdate();

            if(rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                while (rs.next()){
                    int id = rs.getInt(1);
                    System.out.println("Done! Id = " + id);
                }
            }else {
                System.out.println("No rows affected.");
            }

        }
        catch (SQLException e){
            e.printStackTrace();
        }
        catch (ParseException e){
            System.out.println(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }
}
