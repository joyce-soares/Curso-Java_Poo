package application;

import db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
    public static void main(String[] args) {

        Connection coon = null;
        Statement st = null;        // para preparar uma consulta sql
        ResultSet rs = null;        // para guardar o resultado da consulta

        try {
            coon = DB.getConnection(); //conectando ao banco de dados

            st = coon.createStatement();//instanciando o statement

            rs = st.executeQuery("select * from department"); //executa a consulta trazendo o resultado para rs

            while (rs.next()){
                System.out.println(rs.getInt("Id") + ", " + rs.getString("Name")); //exibe o rs linha a linha
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
            DB.closeConnection();
        }

    }
}
