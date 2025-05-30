package com.salarylupin.server.goldenholiday.dto;

import java.time.LocalDate;
import java.util.List;

public record HolidayRecommendRequest(
    LocalDate searchPeriodStart,
    LocalDate searchPeriodEnd,
    int minConsecutiveDaysOff,
    int availableAnnualLeave,
    List<LocalDate> userFixedDaysOff
) {

}
