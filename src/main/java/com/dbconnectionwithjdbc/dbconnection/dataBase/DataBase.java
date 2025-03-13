package com.dbconnectionwithjdbc.dbconnection.dataBase;

import com.dbconnectionwithjdbc.dbconnection.DTO.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

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

    public String addUser(Connection connection, String userName) {
        try {
            UUID uuid = UUID.randomUUID();
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO user (id, name) VALUES (?, ?);");
            pstmt.setString(1, uuid.toString());
            pstmt.setString(2, userName);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected < 0) {
                return "Erro ao adicionar o usuário!";
            }
            return "Usuário adicionado com sucesso!";
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
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

    public String deleteUser(Connection connection, String parameter) {
        try {
            Optional<Person> person = getUser(connection, parameter);
            if (person.isEmpty()) {
                return "Usuário não encontrado!";
            }
            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM user WHERE id = ?");
            pstmt.setString(1, parameter);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected < 0) {
                return "Erro ao deletar o usuário!";
            }
            return "Usuário deletado com sucesso!";
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public String updateUserName(Connection connection, String parameter, String newName) {
        try {
            Optional<Person> person = getUser(connection, parameter);
            if (person.isEmpty()) {
                return "Usuário não encontrado!";
            }
            PreparedStatement pstmt = connection.prepareStatement("UPDATE user SET name = ? WHERE id = ?");
            pstmt.setString(1, newName);
            pstmt.setString(2, parameter);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected < 0) {
                return "Erro ao atualizar o usuário!";
            }
            return "Usuário atualizado com sucesso!";
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
