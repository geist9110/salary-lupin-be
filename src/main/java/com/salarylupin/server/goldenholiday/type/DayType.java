package com.salarylupin.server.goldenholiday.type;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum DayType {
    WEEKEND("주말"),
    PUBLIC_HOLIDAY("공휴일"),
    ANNUAL_LEAVE("연차"),
    DAY_OFF("휴무일");

    String value;
}
