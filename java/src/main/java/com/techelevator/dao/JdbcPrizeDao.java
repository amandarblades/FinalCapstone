package com.techelevator.dao;

import com.techelevator.model.Prize;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPrizeDao implements PrizeDao{

    private final JdbcTemplate jdbcTemplate;
    public JdbcPrizeDao(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}
    

    public void createPrize(Prize newPrize){

    }

    public List<Prize> getActivePrizesByUser(LocalDate startDate, LocalDate endDate){
        List<Prize> prizes = new ArrayList<>();
        String sql = "";

        return prizes;
    }

    public List<Prize> getActivePrizesByFamily(LocalDate startDate, LocalDate endDate){
        List<Prize> prizes = new ArrayList<>();
        return prizes;
    }

    public List<Prize> getCompletedPrizesByUser(LocalDate endDate){
        List<Prize> prizes = new ArrayList<>();
        return prizes;
    }

    public List<Prize> getCompletedPrizesByFamily(LocalDate endDate){
        List<Prize> prizes = new ArrayList<>();
        return prizes;
    }

    public void updatePrize (Prize updatedPrize){}

    public void deletePrize (Prize deletedPrize){}

}
