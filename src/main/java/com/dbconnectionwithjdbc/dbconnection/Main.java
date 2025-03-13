package com.dbconnectionwithjdbc.dbconnection;

import com.dbconnectionwithjdbc.dbconnection.DTO.Person;
import com.dbconnectionwithjdbc.dbconnection.dataBase.DataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://HOST:PORT/DB-NAME";
        String user = "USER";
        String password = "PASSWORD";

        DataBase dataBase = new DataBase();
        Connection connection = dataBase.createConnection(url, user, password);

//        String result = dataBase.addUser(connection, "USER-NAME");
//        System.out.println(result);

//        ArrayList<Person> listPerson = dataBase.getUsers(connection);
//        for (Person person : listPerson) {
//            System.out.println(person.toString());
//        }

//        Optional<Person> person = dataBase.getUser(connection, "USER-ID");
//        if (person.isPresent()) {
//            System.out.println(person.get().toString());
//        } else {
//            System.out.println("Usuário não encontrado!");
//        }

//        String result = dataBase.deleteUser(connection, "USER-ID");
//        System.out.println(result);

//        String result = dataBase.updateUserName(connection, "USER-ID", "NEW-USER-NAME");
//        System.out.println(result);
    }
}
