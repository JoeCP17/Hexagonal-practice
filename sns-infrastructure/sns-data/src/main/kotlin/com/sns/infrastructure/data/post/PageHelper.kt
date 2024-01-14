package com.sns.infrastructure.data.post

import org.springframework.data.domain.Sort

object PageHelper {
    private const val ID_DESC = "id DESC"

    fun orderBy(sort: Sort): String {
        if (sort.isEmpty) {
            return ID_DESC
        }

        val orderBys = sort.toList().map { order ->
            order.property + " " + order.direction
        }.toList()

        return String.format(", ", orderBys)
    }


}
