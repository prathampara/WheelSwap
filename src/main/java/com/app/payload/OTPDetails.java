package com.app.payload;

public class OTPDetails {
    private final String otp;

    public long getTimestamp() {
        return timestamp;
    }

    public String getOtp() {
        return otp;
    }

    private final long timestamp;

    public OTPDetails(String otp, long timestamp) {
        this.otp = otp;
        this.timestamp = timestamp;
    }
}
