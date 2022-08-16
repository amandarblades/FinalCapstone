package com.techelevator.controller;

import com.techelevator.dao.PrizeDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Prize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class PrizeController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PrizeDao prizeDao;

    public PrizeController(UserDao userDao, PrizeDao prizeDao){
        this.userDao = userDao;
        this.prizeDao = prizeDao;
    }

    @RequestMapping(value = "/addprize", method = RequestMethod.POST)
    public void addPrize(@Valid @RequestBody Prize prize, Principal principal){
        String username = "Nate"; //getCurrentUsername(principal);
        Integer prizeId = prizeDao.createPrize(prize);
        prizeDao.addUsersToPrize(username, prizeId, prize.getUserRole());
    }

    @RequestMapping(value = "/getprizes", method = RequestMethod.GET)
    public List<Prize> getUserPrizes(Principal principal){
        List<Prize> prizes = new ArrayList<>();
        String username = "Amanda"; //getCurrentUsername(principal);
        prizes = prizeDao.getActivePrizesByUser(username);
        return prizes;
    }

    private String getCurrentUsername(Principal principal){
        return principal.getName();}

}
