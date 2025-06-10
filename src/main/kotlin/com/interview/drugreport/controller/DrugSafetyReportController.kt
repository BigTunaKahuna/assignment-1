package com.interview.drugreport.controller

import com.interview.drugreport.dto.DrugSafetyReportResponse
import com.interview.drugreport.dto.DrugSafetyReportFilter
import com.interview.drugreport.dto.DrugSafetyReportRequest
import com.interview.drugreport.service.DrugSafetyReportService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/drug-reports")
class DrugSafetyReportController (
    private val drugSafetyReportService: DrugSafetyReportService
){

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    fun getReports(@RequestParam id: Int): DrugSafetyReportResponse {
        return drugSafetyReportService.getReports(id)
    }

    @PostMapping("/filter")
    @ResponseStatus(HttpStatus.OK)
    fun getReports(@RequestBody filter: DrugSafetyReportFilter): List<DrugSafetyReportResponse> {
        return drugSafetyReportService.getReports(filter)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun saveReport(@RequestBody request: DrugSafetyReportRequest) {
        drugSafetyReportService.createReport(request)
    }
}