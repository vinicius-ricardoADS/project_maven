package com.pw3.repository;

import java.util.List;

import com.pw3.model.Pessoa;

public interface PessoaDao {

    Integer add(Pessoa p);

    boolean update(Pessoa p);

    boolean delete(Integer key);

    List<Pessoa> findAll();

    Pessoa findyByUsernameAndPassword(String username);
}
