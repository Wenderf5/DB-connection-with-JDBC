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

//        ArrayList<Person> listPerson = dataBase.getUsers(connection);
//        for (Person person : listPerson) {
//            System.out.println(person.toString());
//        }

//        Optional<Person> person = dataBase.getUser(connection, "c042742b-183d-4f7b-b88f-609ea311bc5d");
//        if (person.isPresent()) {
//            System.out.println(person.get().toString());
//        } else {
//            System.out.println("Usuário não encontrado!");
//        }


    }
}
