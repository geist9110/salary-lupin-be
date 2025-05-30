package com.salarylupin.server.goldenholiday.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.Min;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

public record HolidayRecommendRequest(

    @FutureOrPresent(message = "검색 시작일은 현재 또는 미래 날짜여야 합니다.")
    LocalDate searchPeriodStart,

    @FutureOrPresent(message = "검색 종료일은 현재 또는 미래 날짜여야 합니다.")
    LocalDate searchPeriodEnd,

    @Min(value = 2, message = "최소 연속 휴무일은 2일 이상이어야 합니다.")
    Integer minConsecutiveDaysOff,

    @Min(value = 0, message = "사용 가능 연차는 0개 이상이어야 합니다.")
    Integer availableAnnualLeave,

    List<LocalDate> userFixedDaysOff
) {

    private static final LocalDate MIN_DATE_RANGE = LocalDate.of(2000, 1, 1);
    private static final LocalDate MAX_DATE_RANGE = LocalDate.of(2099, 12, 31);

    public HolidayRecommendRequest {
        if (searchPeriodStart == null) {
            searchPeriodStart = LocalDate.now();
        }
        if (searchPeriodEnd == null) {
            searchPeriodEnd = LocalDate.now().plusMonths(3);
        }
        if (minConsecutiveDaysOff == null) {
            minConsecutiveDaysOff = 3;
        }
        if (availableAnnualLeave == null) {
            availableAnnualLeave = 0;
        }
        if (userFixedDaysOff == null) {
            userFixedDaysOff = Collections.emptyList();
        }
    }

    @AssertTrue(message = "검색 시작일은 2000-01-01과 2099-12-31 사이여야 합니다.")
    private boolean isSearchPeriodStartValidRange() {
        return !searchPeriodStart.isBefore(MIN_DATE_RANGE) && !searchPeriodStart.isAfter(
            MAX_DATE_RANGE);
    }

    @AssertTrue(message = "검색 종료일은 2000-01-01과 2099-12-31 사이여야 합니다.")
    private boolean isSearchPeriodEndValidRange() {
        return !searchPeriodEnd.isBefore(MIN_DATE_RANGE) && !searchPeriodEnd.isAfter(
            MAX_DATE_RANGE);
    }

    @AssertTrue(message = "검색 종료일은 검색 시작일보다 이후이거나 같아야 합니다.")
    private boolean isSearchPeriodOrderValid() {
        return !searchPeriodEnd.isBefore(searchPeriodStart);
    }

    @AssertTrue(message = "사용자 지정 휴무일 목록의 각 날짜는 2000-01-01과 2099-12-31 사이여야 하며, null일 수 없습니다.")
    private boolean isUserFixedDaysOffElementsValid() {
        if (userFixedDaysOff.isEmpty()) {
            return true;
        }
        for (LocalDate date : userFixedDaysOff) {
            if (date == null) {
                return false;
            }
            if (date.isBefore(MIN_DATE_RANGE) || date.isAfter(MAX_DATE_RANGE)) {
                return false;
            }
        }
        return true;
    }
}