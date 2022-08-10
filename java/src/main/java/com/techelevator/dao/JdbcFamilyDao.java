package com.techelevator.dao;

import com.techelevator.model.Family;
import com.techelevator.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcFamilyDao implements FamilyDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcFamilyDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    @Override
    public void createFamily(String username, String familyName){
        String sqlNewFamily = "INSERT INTO family_unit(family_name) VALUES(?);";
        String sqlAddUser = "INSERT INTO user_family(user_id, family_id) " +
                "VALUES((SELECT user_id FROM users WHERE username = ?), " +
                "(SELECT id FROM family_unit WHERE family_name = ?));";
        jdbcTemplate.update(sqlNewFamily, familyName);
        jdbcTemplate.update(sqlAddUser, username, familyName);
    }

    @Override
    public void addFamilyMember (String username, String currentUser){
        String sqlFamilyName = "SELECT family_name FROM family_unit f " +
                "JOIN user_family uf ON uf.family_id = f.id " +
                "JOIN users u ON u.user_id = uf.user_id " +
                "WHERE username = ?; ";
        String familyName = jdbcTemplate.queryForObject(sqlFamilyName, String.class, currentUser);
        String sqlAddUser = "INSERT INTO user_family(user_id, family_id) " +
                "VALUES((SELECT user_id FROM users WHERE username = ?), " +
                "(SELECT id FROM family_unit WHERE family_name = ?));";
        jdbcTemplate.update(sqlAddUser, username, familyName);
    }

    @Override
    public List<User> returnAllFamilyMembers(int familyID){
        List<User> users = new ArrayList<>();


        return users;
    }

    @Override
    public void removeFamilyMember(String username, String currentUser){
        String sqlFamilyName = "SELECT family_name FROM family_unit f " +
                "JOIN user_family uf ON uf.family_id = f.id " +
                "JOIN users u ON u.user_id = uf.user_id " +
                "WHERE username = ?; ";
        String familyName = jdbcTemplate.queryForObject(sqlFamilyName, String.class, currentUser);
        String sql = "DELETE FROM user_family WHERE " +
                "(user_id = (SELECT user_id FROM users WHERE username = ?) AND " +
                "family_id = (SELECT id FROM family_unit WHERE family_name = ?));";
        jdbcTemplate.update(sql, username, familyName);
    }

    public Family mapRowToFamily(SqlRowSet rs){
        Family family = new Family();
        family.setFamilyID(rs.getInt("id"));
        family.setFamilyName(rs.getString("family_name"));
        return family;
    }

}
