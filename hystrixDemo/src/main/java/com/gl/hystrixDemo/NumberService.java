package com.gl.hystrixDemo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class NumberService {


    @HystrixCommand(fallbackMethod = "fallbackCall")
    public String deriveStringWithNumber()  {
        int num = new Random().nextInt(10);
        if(num % 3 ==0){
            return "Our number is divisible by 3 now!!";
        }else{
            throw new RuntimeException("working to get the number you need");
        }
    }

    public String fallbackCall(){
        return "The number is not divisible by!!! Wait for some more time";
    }
}
