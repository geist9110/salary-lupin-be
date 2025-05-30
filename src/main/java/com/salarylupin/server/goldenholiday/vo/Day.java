package com.salarylupin.server.goldenholiday.vo;

import com.salarylupin.server.goldenholiday.type.DayType;
import java.time.LocalDate;

public class Day {

    private LocalDate date;
    private DayType dayType;
    private String name;

    public Day(LocalDate date, DayType dayType, String name) {
        this.date = date;
        this.dayType = dayType;

        if (this.dayType.equals(DayType.PUBLIC_HOLIDAY) && name.isBlank()) {
            throw new IllegalArgumentException("공휴일에는 이름이 필요합니다.");
        }

        this.name = name;
    }
}
