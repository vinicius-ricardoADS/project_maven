package com.pw3.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pw3.model.Pessoa;

public class SQLiteDaoPessoa implements PessoaDao {

    @Override
    public synchronized Integer add(Pessoa pessoa) {
        String sql = """
                INSERT INTO Pessoa (
                    username,
                    name,
                    hashPassword,
                ) VALUES (
                    ?,
                    ?,
                    ?
                );
                """;
        try (PreparedStatement stmt = Database.createPreparedStatement(sql)) {
            stmt.setString(1, pessoa.getUsername());
            stmt.setString(2, pessoa.getName());
            stmt.setString(3, pessoa.getPassword());
            stmt.execute();
            ResultSet rs = stmt.getGeneratedKeys();
            return rs.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public synchronized boolean update(Pessoa pessoa) {// SQLITE
        String sql = """
                    UPDATE Pessoa set
                        username = ?,
                        name = ?,
                        hashPassword = ?
                    WHERE id = ?
                """;

        try (PreparedStatement stmt = Database.createPreparedStatement(sql)) {
            stmt.setString(1, pessoa.getUsername());
            stmt.setString(2, pessoa.getName());
            stmt.setString(3, pessoa.getPassword());
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(Integer id) {
        String sql = "DELETE FROM Pessoa WHERE id = ?";
        try (PreparedStatement stmt = Database.createPreparedStatement(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Pessoa> findAll() {
        String sql = """
                    SELECT
                        id,
                        username,
                        name,
                        hashPassword,
                    FROM Pessoa p
                """;
        List<Pessoa> pessoas = new ArrayList<>();
        try (PreparedStatement stmt = Database.createPreparedStatement(sql)) {
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                Pessoa pessoa = new Pessoa(resultSet.getInt("id"), resultSet.getString("username"),
                        resultSet.getString("name"), resultSet.getString("hashPassword"));
                pessoas.add(pessoa);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pessoas;
    }

    @Override
    public Pessoa findyByUsernameAndPassword(String username) {
        String sql = """
                    SELECT
                        id,
                        username,
                        name,
                        hashPassword
                    WHERE username = ?
                """;
        try (PreparedStatement stmt = Database.createPreparedStatement(sql)) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Pessoa(rs.getInt("id"), rs.getString("username"),
                        rs.getString("name"), rs.getString("hashPassword"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
