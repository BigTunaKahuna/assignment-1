package com.interview.drugreport.dto

import com.interview.drugreport.repository.model.ReportStatus
import java.time.LocalDateTime

data class DrugSafetyReportResponse(
    val id: Int,
    val reporterName: String,
    val productName: String,
    val issueDescription: String,
    val ts: LocalDateTime = LocalDateTime.now(),
    val status: ReportStatus = ReportStatus.NEW
)