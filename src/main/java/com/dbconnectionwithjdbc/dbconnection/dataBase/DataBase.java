package com.dbconnectionwithjdbc.dbconnection.dataBase;

import com.dbconnectionwithjdbc.dbconnection.DTO.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class DataBase {
    public Connection createConnection(String url, String user, String password) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException();
        }
    }

    public ArrayList<Person> getUsers(Connection connection) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM user");
            ResultSet rs = pstmt.executeQuery();
            ArrayList<Person> personList = new ArrayList<>();
            while (rs.next()) {
                personList.add(new Person(rs.getString("id"), rs.getString("name")));
            }
            return personList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public Optional<Person> getUser(Connection connection, String parameter) {
        try {
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM user WHERE id = ?");
            pstmt.setString(1, parameter);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return Optional.of(new Person(rs.getString("id"), rs.getString("name")));
            }
            return Optional.empty();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
