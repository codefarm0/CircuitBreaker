package com.gl.orderManagementApp.service;

import com.gl.orderManagementApp.dto.SellerDto;
import com.gl.orderManagementApp.service.hsytrix.UserRegistrationHystrix;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author - GreenLearner(https://www.youtube.com/channel/UCaH2MTg94hrJZTolW01a3ZA)
 */

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

    Logger logger = LoggerFactory.getLogger(UserRegistrationServiceImpl.class);
    private UserRegistrationHystrix userRegistrationHystrix;


    public UserRegistrationServiceImpl(UserRegistrationHystrix userRegistrationHystrix) {
        this.userRegistrationHystrix = userRegistrationHystrix;
    }

    @Override
    public String registerSeller(SellerDto sellerDto) {
        long start = System.currentTimeMillis();
        String registerSeller = userRegistrationHystrix.registerSeller(sellerDto);
        logger.info("add seller call returned in - {}", System.currentTimeMillis() - start);
        return registerSeller;

    }

    @Override
    public List<SellerDto> getSellersList() {
        return userRegistrationHystrix.getSellersList();
    }
}
