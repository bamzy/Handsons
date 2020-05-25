package com.bamzy.utils;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {

    public String Login;
    public String MotDePasse;
    private boolean Logged = false;



            public void StartBdd(){
                String driverName = "com.mysql.jdbc.Driver";
                try {
                    Class.forName(driverName); // here is the ClassNotFoundException
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                String serverName = "localhost";
                String mydatabase = "world";
                String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

                String username = "root";
                String password = "admin";

                String sql = "insert into city values('5000','1','ARM','1','1')";
                Connection con=null;
                try
                {

                    Connection connection = DriverManager.getConnection(url, username, password);
                    Statement st = connection.createStatement();
                    int m = st.executeUpdate(sql);
                    if (m == 1)
                        System.out.println("inserted successfully : "+sql);
                    else
                        System.out.println("insertion failed");
                    con.close();
                }
                catch(Exception ex)
                {
                    System.err.println(ex);
                }
            }
}