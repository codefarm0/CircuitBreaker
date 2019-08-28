package com.gl.orderManagementApp.service.hsytrix;

import com.gl.orderManagementApp.dto.SellerDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @author - GreenLearner(https://www.youtube.com/channel/UCaH2MTg94hrJZTolW01a3ZA)
 */

@Service
public class UserRegistrationHystrix {
    Logger logger = LoggerFactory.getLogger(UserRegistrationHystrix.class);
    private RestTemplate restTemplate;

    public UserRegistrationHystrix(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "fallbackForRegisterSeller", commandKey = "ordermanagement")
    public String registerSeller(SellerDto sellerDto) {
        String response = restTemplate.postForObject("/addSeller", sellerDto, String.class);
        return response;
    }

    public List<SellerDto> getSellersList() {
        return restTemplate.getForObject("/sellersList", List.class);
    }

    public String fallbackForRegisterSeller(SellerDto sellerDto, Throwable t) {
        logger.error("Inside fall back, cause - {}", t.toString());
        return "Inside fallback method. Some error occured while calling service for seller registration";
    }
}
