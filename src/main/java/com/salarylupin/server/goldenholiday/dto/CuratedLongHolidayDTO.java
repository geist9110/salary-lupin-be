package com.salarylupin.server.goldenholiday.dto;

import java.time.LocalDate;

public record CuratedLongHolidayDTO(
    LocalDate startDate,
    LocalDate endDate
) {
    
}
