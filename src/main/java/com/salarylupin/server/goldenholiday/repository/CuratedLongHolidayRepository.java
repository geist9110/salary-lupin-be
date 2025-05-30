package com.salarylupin.server.goldenholiday.repository;

import com.salarylupin.server.goldenholiday.entity.CuratedLongHoliday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CuratedLongHolidayRepository extends JpaRepository<CuratedLongHoliday, Long> {

}