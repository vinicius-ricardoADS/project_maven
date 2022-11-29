package com.pw3.model;

import com.pw3.bcrypt.Hash;

public class PessoaHashPassword {
    public static void create(Pessoa pessoa) {
        String virtualPassword = pessoa.getPassword();
        String passwordHash = Hash.hash(virtualPassword, 12);
        pessoa.setPassword(passwordHash);
    }
}
