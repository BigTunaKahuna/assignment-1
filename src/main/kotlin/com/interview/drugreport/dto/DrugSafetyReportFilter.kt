package com.interview.drugreport.dto

import com.interview.drugreport.repository.model.ReportStatus
import org.hibernate.query.SortDirection
import java.time.LocalDateTime

data class DrugSafetyReportFilter(
    val ids: Set<Int> = emptySet(),
    val tsBefore: LocalDateTime? = null,
    val tsAfter: LocalDateTime? = null,
    val sortByTs: Boolean = false,
    val sortDirection: SortDirection = SortDirection.DESCENDING,
    val reporterName: String? = null,
    val productName: String? = null,
    val status: ReportStatus? = null,
    val page: Int = 0,
    val pageSize: Int = 10
)