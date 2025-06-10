package com.interview.drugreport.mapper

import com.interview.drugreport.dto.DrugSafetyReportRequest
import com.interview.drugreport.dto.DrugSafetyReportResponse
import com.interview.drugreport.repository.model.DrugSafetyReport

class DrugSafetyReportMapper {
    fun toResponse(drugSafetyReport: DrugSafetyReport) =
        with(drugSafetyReport) {
            DrugSafetyReportResponse(
                id,
                reporterName,
                productName,
                issueDescription,
                ts,
                status
            )
        }

    fun toEntity(dto: DrugSafetyReportResponse) =
        with(dto) {
            DrugSafetyReport(
                id,
                reporterName,
                productName,
                issueDescription,
                ts,
                status
            )
        }

    fun toEntity(req: DrugSafetyReportRequest) =
        with(req) {
            DrugSafetyReport(
                reporterName = reporterName,
                productName = productName,
                issueDescription = issueDescription,
                status = status
            )
        }
}