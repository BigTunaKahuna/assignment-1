package com.interview.drugreport

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@EnableJpaRepositories
class DrugReportApplication

fun main(args: Array<String>) {
    runApplication<DrugReportApplication>(*args)
}
