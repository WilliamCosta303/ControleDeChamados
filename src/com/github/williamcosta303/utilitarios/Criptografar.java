package com.github.williamcosta303.utilitarios;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Criptografar {
    private String senha;

    public Criptografar() {
    }
    
    public String criptografarSenha(String valorACriptografar) throws Error{
        String res = "NULL";
        
        try{
            String senha = valorACriptografar;
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(senha.getBytes(),0,senha.length());
            res = new BigInteger(1,m.digest()).toString(16);
        }catch(NoSuchAlgorithmException NSAE){
            throw new Error("Erro ao criptografar a senha!\nCausa: " + NSAE.getMessage());
        }
        
        return res;
    }
}
