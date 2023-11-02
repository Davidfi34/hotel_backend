package com.hotelapp.guestRegistration.services.helper;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
public class GuestRegistrationCalculatorHelper {
    /***
     * total costs per number of days and room category
     * @param checkInDate
     * @param checkOutDate
     * @param dailyRate
     * @return BigDecimal total
     */
    public BigDecimal guestRegistrationCalculator(Date checkInDate, Date checkOutDate, BigDecimal dailyRate ){
        Long diffInMillies = Math.abs(checkOutDate.getTime() - checkInDate.getTime());
        Long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        BigDecimal day = new BigDecimal(diffInDays);
        BigDecimal total = day.multiply(dailyRate);
        return  total.equals(new BigDecimal(0.0)) ? total : dailyRate;
    }
}
