package com.interview.drugreport.repository.converter

import com.interview.drugreport.repository.model.ReportStatus
import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter(autoApply = true)
class ReportStatusConverter : AttributeConverter<ReportStatus, Int> {
    override fun convertToDatabaseColumn(status: ReportStatus): Int = status.dbValue
    override fun convertToEntityAttribute(dbValue: Int): ReportStatus = ReportStatus.fromDbValue(dbValue)
}
