package com.ny.test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateDiff {

    public static void main(String[] args) {
        final LocalDate fromDayInclusive = LocalDate.now();
        final LocalDate toDate = fromDayInclusive.plusMonths(7);
        System.out.println(toDate);
        /*final LocalDate toDayExclusive = LocalDate.of(2019, 5, 15);
        final ChronoUnit unit = ChronoUnit.MONTHS;
        final long between = unit.between(fromDayInclusive, toDayExclusive);
        System.out.println(between + " " + unit);*/
    }

}
