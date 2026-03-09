package com.docencia.util;

import java.util.regex.Pattern;

import com.docencia.model.Usuario;

public class Validaciones extends Usuario {

    public Validaciones(int id) {
        super(id);
    }

    public static String normalizarEmail(String email){
        if(email == null || email.isBlank()){
            return null;
        }
        return email.trim().toLowerCase();
    }

    public static boolean  validarEmail(String email) {
        email = normalizarEmail(email);
        if(email == null){
            return false;
        }
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return Pattern.matches(email, regex);
    }

    public static boolean passwordValido(String password){
        return true;
    }

    public static void validarNombre(String nombre){
        return;
    }

    public static void validarPassword(String password) {
        return;
    }
}
