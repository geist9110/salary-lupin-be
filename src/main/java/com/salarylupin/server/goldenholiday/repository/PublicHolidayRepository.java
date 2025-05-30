package com.salarylupin.server.goldenholiday.repository;

import com.salarylupin.server.goldenholiday.entity.PublicHoliday;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublicHolidayRepository extends JpaRepository<PublicHoliday, Integer> {

}
