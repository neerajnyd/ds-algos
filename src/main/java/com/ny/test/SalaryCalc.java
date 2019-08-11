package com.ny.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class SalaryCalc {
    public static void main(String[] args) {
        final BigDecimal totalAmount = BigDecimal.valueOf(1056028);
        final LocalDate fromDayInclusive = LocalDate.of(2018, 6, 4);
        final LocalDate toDayExclusive = LocalDate.of(2019, 4, 1);
        final BigDecimal paidForDays = BigDecimal.valueOf(ChronoUnit.DAYS.between(fromDayInclusive, toDayExclusive));
        final BigDecimal totalDays = BigDecimal.valueOf(365);
        final BigDecimal grossSalaryEarnings = totalAmount.multiply(totalDays).divide(paidForDays, RoundingMode.FLOOR);
        final BigDecimal dollarToRupeeValue = BigDecimal.valueOf(70.22);
        final BigDecimal sharesValueInDollars = BigDecimal.valueOf(2113.94);
        final BigDecimal grossEarnings = grossSalaryEarnings.add(sharesValueInDollars.multiply(dollarToRupeeValue));
        System.out.println(grossEarnings);
    }
}
