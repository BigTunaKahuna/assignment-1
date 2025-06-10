package com.interview.drugreport.repository.model

enum class ReportStatus(val dbValue: Int) {
    NEW(1),
    IN_REVIEW(2),
    CLOSED(3);

    companion object {
        fun fromDbValue(value: Int) = ReportStatus.entries.first { it.dbValue == value }
    }
}