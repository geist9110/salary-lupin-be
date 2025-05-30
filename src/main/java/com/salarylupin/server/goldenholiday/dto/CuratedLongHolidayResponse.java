package com.salarylupin.server.goldenholiday.dto;

import java.time.LocalDate;

public record CuratedLongHolidayResponse(
    LocalDate startDate,
    LocalDate endDate
) {
    
}
