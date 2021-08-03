package application;

import db.DB;
import db.DbException;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
    public static void main(String[] args) {

        Connection conn = null;
        Statement st = null;
        try {
            conn = DB.getConnection();

            conn.setAutoCommit(false); //nao confirma as operacoes automaticamente, operacoes por padrao ficam pendentes

            st = conn.createStatement();

            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2000 WHERE DepartmentId = 1");

            /*int x = 1;
            if(x<2){
                throw new SQLException("Fake Error");
            }*/

            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3000 WHERE DepartmentId = 2");

            conn.commit(); //confirma a transacao;

            System.out.println("Rows 1: " + rows1);
            System.out.println("Rows 2: " + rows2);


        }catch (SQLException e){
            try {
                conn.rollback(); //volta ao estado inicial do banco
                throw new DbException("Transaction rolled back. Caused by: " + e.getMessage());
            } catch (SQLException e1) {
               throw new DbException("Error trying to rollback!. Caused by: " + e1.getMessage());
            }
        }
        finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }
}
