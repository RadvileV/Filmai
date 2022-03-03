package com.example.filmai.utils;

import java.net.HttpURLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static final String USERNAME_REGEX_PATTERN = "^[A-Za-z0-9]{5,13}$";

    public static boolean isValidUsername (String username){
        //Sukuriamos validacijos taisyklės pagal anksčiau apsirašytą šabloną
        Pattern pattern = Pattern.compile(USERNAME_REGEX_PATTERN);
        //Validacijos atitikmens sukūrimas palyginant vartotojo įvestą username su validacijos taisyklėmis
        Matcher matcher = pattern.matcher(username);
        //Grąžins true jeigu atitiks vartotojo susikurtas vardas mūsų susikurtą validaciją, priešingu atveju - false.
        return matcher.find();
    }
}
