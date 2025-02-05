package com.app.service;

import com.app.payload.OTPDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class OTPService {
    private final Map<String, OTPDetails> otpStorage = new HashMap<>();
    private static final int OTP_EXPIRY_TIME=5;
    public String generatedOTP(String mobileNumber){
        String otp= String.format("%06d",new Random().nextInt(999999));
        OTPDetails otpDetails = new OTPDetails(otp,System.currentTimeMillis());
        otpStorage.put(mobileNumber,otpDetails);
        return otp;
    }
}
