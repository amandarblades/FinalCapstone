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
        String username = getCurrentUsername(principal);
        Integer prizeId = prizeDao.createPrize(prize);
        prizeDao.addUsersToPrize(username, prizeId, prize.getUserRole());
    }

    @RequestMapping(value = "/getprizes", method = RequestMethod.GET)
    public List<Prize> getUserPrizes(Principal principal){
        List<Prize> prizes = new ArrayList<>();
        String username = getCurrentUsername(principal);
        String userRole = userDao.getUserRole(username);
        prizes = prizeDao.getActivePrizes(username, userRole);
        return prizes;
    }

//    @RequestMapping(value = "/getfamilyprizes", method = RequestMethod.GET)
//    public List<Prize> getFamilyPrizes(Principal principal){
//        List<Prize> prizes = new ArrayList<>();
//        String username = "Nate"; //getCurrentUsername(principal);
//        prizes = prizeDao.getActivePrizesByFamily(username);
//        return prizes;
//
//    }

    @RequestMapping(value = "/deleteprize/{id}", method = RequestMethod.DELETE)
    public void deletePrize(@PathVariable int id){
        prizeDao.deletePrize(id);
    }

    @RequestMapping(value = "/updateprize", method = RequestMethod.PUT)
    public void updatePrize(@Valid @RequestBody Prize prize){
        prizeDao.updatePrize(prize);
    }

    private String getCurrentUsername(Principal principal){
        return principal.getName();}

}
