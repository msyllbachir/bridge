package com.example.bridge;

import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;
import static org.junit.Assert.assertEquals;

public class TestDateTest {


    @Test
    public void testDate(){
        for (int deb = 0; deb < 1000; deb++) {
            LocalDate NOW = LocalDate.now().minusDays(31).plusDays(deb);
            LocalDate plusMonths = NOW.plusMonths(1);
            long between = DAYS.between(NOW, plusMonths);
            List<LocalDate> list = new ArrayList<>();
            list.add(NOW.plusDays(2));
            for (int i = 0; i < 6; i++) {
                if(0==(i*7)%between)
                    list.add(NOW.plusWeeks(i).minusDays(1));
                else list.add(NOW.plusWeeks(i));
            }

            for (int i = 0; i < 6; i++) {
                if(0==(i*7)%between)
                    list.add(NOW.plusWeeks(i).minusDays(1));
                else list.add(NOW.plusWeeks(i));
            }
            System.out.println(list);
            final StringBuilder stringBuilder = new StringBuilder();
            list.forEach(
                    localDate -> {
                        if (localDate.isBefore(plusMonths))
                            stringBuilder.append("-");}
            );
            assertEquals(11, stringBuilder.length());
        }

    }

}