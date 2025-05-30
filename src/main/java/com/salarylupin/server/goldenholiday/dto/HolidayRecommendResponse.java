package com.salarylupin.server.goldenholiday.dto;

import com.salarylupin.server.goldenholiday.vo.Day;
import java.time.LocalDate;
import java.util.List;

public record HolidayRecommendResponse(
    LocalDate startDate,
    LocalDate endDate,
    int totalDaysOff,
    int annualLeaveUsed,
    List<Day> daysOff
) {

}
