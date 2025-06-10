package com.interview.drugreport.service

import com.interview.drugreport.dto.DrugSafetyReportResponse
import com.interview.drugreport.dto.DrugSafetyReportFilter
import com.interview.drugreport.dto.DrugSafetyReportRequest
import com.interview.drugreport.exception.ResourceNotFoundException
import com.interview.drugreport.mapper.DrugSafetyReportMapper
import com.interview.drugreport.repository.DrugSafetyReportRepository
import jakarta.transaction.Transactional

@Transactional
class DrugSafetyReportService(
    private val drugSafetyReportRepository: DrugSafetyReportRepository,
    private val drugSafetyReportMapper: DrugSafetyReportMapper
) {

    fun getReports(id: Int): DrugSafetyReportResponse {
        return drugSafetyReportRepository
            .findById(id)
            .orElseThrow { ResourceNotFoundException("Cannot find report with id: $id") }.let {
                drugSafetyReportMapper.toResponse(it)
            }
    }

    fun createReport(drugSafetyReport: DrugSafetyReportRequest) {
        drugSafetyReportMapper.toEntity(drugSafetyReport).let {
            drugSafetyReportRepository
                .save(it)
        }
    }

    fun getReports(filter: DrugSafetyReportFilter): List<DrugSafetyReportResponse> {
        return drugSafetyReportRepository.findByFilter(filter).map {
            drugSafetyReportMapper.toResponse(it)
        }
    }
}