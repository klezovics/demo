package com.klezovich.demo.components.dates;

import java.time.LocalDate;

public class BirthdayCalculation {

    public boolean birthdayDuringStay(LocalDate arrival, LocalDate departure, LocalDate birthday) {

        var birthdayDay = birthday.getDayOfMonth();
        var birthdayMonth = birthday.getMonth();
        var currentYear = LocalDate.now().getYear();

        var birthDayThisYear = LocalDate.of(currentYear, birthdayMonth, birthdayDay);

        if (birthDayThisYear.isEqual(arrival))
            return true;

        if (birthDayThisYear.isEqual(departure))
            return true;

        return birthDayThisYear.isAfter(arrival) && birthDayThisYear.isBefore(departure);
    }
}
