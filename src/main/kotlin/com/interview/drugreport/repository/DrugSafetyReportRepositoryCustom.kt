package com.interview.drugreport.repository

import com.interview.drugreport.dto.DrugSafetyReportFilter
import com.interview.drugreport.repository.model.DrugSafetyReport

interface DrugSafetyReportRepositoryCustom {
    fun findByFilter(filter: DrugSafetyReportFilter): List<DrugSafetyReport>
}
