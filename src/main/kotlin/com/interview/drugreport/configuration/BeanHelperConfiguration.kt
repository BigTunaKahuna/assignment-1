package com.interview.drugreport.configuration

import com.interview.drugreport.mapper.DrugSafetyReportMapper
import com.interview.drugreport.repository.DrugSafetyReportRepository
import com.interview.drugreport.service.DrugSafetyReportService
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class BeanHelperConfiguration {

    @Bean
    fun drugSafetyReportMapper(): DrugSafetyReportMapper {
        return DrugSafetyReportMapper()
    }

    @Bean
    fun drugSafetyReportService(
        drugSafetyReportRepository: DrugSafetyReportRepository,
        drugSafetyReportMapper: DrugSafetyReportMapper
    ): DrugSafetyReportService {
        return DrugSafetyReportService(
            drugSafetyReportRepository,
            drugSafetyReportMapper
        )
    }
}
