package com.interview.drugreport.repository

import com.interview.drugreport.dto.DrugSafetyReportFilter
import com.interview.drugreport.repository.model.DrugSafetyReport
import com.interview.drugreport.repository.model.ReportStatus
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext
import jakarta.persistence.criteria.Predicate
import org.hibernate.query.SortDirection
import java.time.LocalDateTime

class DrugSafetyReportRepositoryImpl(
    @PersistenceContext
    private val em: EntityManager
): DrugSafetyReportRepositoryCustom {

    override fun findByFilter(filter: DrugSafetyReportFilter): List<DrugSafetyReport> {
        val cb = em.criteriaBuilder
        val cq = cb.createQuery(DrugSafetyReport::class.java)
        val root = cq.from(DrugSafetyReport::class.java)

        val predicates = mutableListOf<Predicate>()

        if (filter.ids.isNotEmpty()) {
            predicates.add(root.get<Int>("id").`in`(filter.ids))
        }

        filter.tsAfter?.let {
            predicates.add(cb.greaterThanOrEqualTo(root.get("ts"), it))
        }

        filter.tsBefore?.let {
            predicates.add(cb.lessThanOrEqualTo(root.get("ts"), it))
        }

        filter.reporterName?.let {
            predicates.add(cb.like(cb.lower(root.get("reporterName")), "%${it.lowercase()}%"))
        }

        filter.productName?.let {
            predicates.add(cb.like(cb.lower(root.get("productName")), "%${it.lowercase()}%"))
        }

        filter.status?.let {
            predicates.add(cb.equal(root.get<ReportStatus>("status"), it))
        }

        cq.where(*predicates.toTypedArray())

        if (filter.sortByTs) {
            val order = if (filter.sortDirection == SortDirection.ASCENDING) {
                cb.asc(root.get<LocalDateTime>("ts"))
            } else {
                cb.desc(root.get<LocalDateTime>("ts"))
            }
            cq.orderBy(order)
        }

        val query = em.createQuery(cq)

        query.firstResult = filter.page * filter.pageSize
        query.maxResults = filter.pageSize

        return query.resultList
    }
}
