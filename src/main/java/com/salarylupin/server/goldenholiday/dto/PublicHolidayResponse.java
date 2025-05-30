package com.salarylupin.server.goldenholiday.dto;

import com.salarylupin.server.goldenholiday.vo.Day;
import java.util.List;

public record PublicHolidayResponse(
    List<Day> holidays
) {

}
