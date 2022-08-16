package com.techelevator.dao;

import com.techelevator.model.Prize;

import java.time.LocalDate;
import java.util.List;

public interface PrizeDao {

    public void createPrize(Prize newPrize);

    public List<Prize> getActivePrizesByUser(LocalDate startDate, LocalDate endDate);

    public List<Prize> getActivePrizesByFamily(LocalDate startDate, LocalDate endDate);

    public List<Prize> getCompletedPrizesByUser(LocalDate endDate);

    public List<Prize> getCompletedPrizesByFamily(LocalDate endDate);

    public void updatePrize (Prize updatedPrize);

    public void deletePrize (Prize deletedPrize);


}
