package com.techelevator.dao;

import com.techelevator.model.Prize;

import java.time.LocalDate;
import java.util.List;

public interface PrizeDao {

    public void createPrize(Prize newPrize);

    public List<Prize> getActivePrizesByUser(String username);

    public List<Prize> getActivePrizesByFamily(String username);

    public void updateUserPrizeCompletion(Prize prize, String username);

    public void updatePrizeCompletion(Prize prize);

    public void updatePrize (Prize updatedPrize);

    public void deletePrize (Prize deletedPrize);


}
