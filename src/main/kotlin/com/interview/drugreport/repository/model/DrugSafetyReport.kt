package com.interview.drugreport.repository.model

import com.interview.drugreport.repository.converter.ReportStatusConverter
import jakarta.persistence.Column
import jakarta.persistence.Convert
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "drug_safety_report")
class DrugSafetyReport(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,
    val reporterName: String,
    val productName: String,
    val issueDescription: String,
    val ts: LocalDateTime = LocalDateTime.now(),
    @Convert(converter = ReportStatusConverter::class)
    @Column(name = "status_id")
    val status: ReportStatus = ReportStatus.NEW
)