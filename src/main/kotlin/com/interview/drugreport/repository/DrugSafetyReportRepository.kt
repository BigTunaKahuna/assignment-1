package com.interview.drugreport.repository

import com.interview.drugreport.repository.model.DrugSafetyReport
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface DrugSafetyReportRepository: JpaRepository<DrugSafetyReport, Int>, DrugSafetyReportRepositoryCustom
