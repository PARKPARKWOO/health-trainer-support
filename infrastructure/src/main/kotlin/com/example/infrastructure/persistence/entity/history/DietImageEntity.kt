package com.example.infrastructure.persistence.entity.history

import com.example.core.history.model.Diet
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.JdbcTypeCode
import org.hibernate.type.SqlTypes
import java.util.UUID

const val DIET_IMAGE_TABLE_NAME = "diet_image"

@Entity
@Table(name = DIET_IMAGE_TABLE_NAME)
class DietImageEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    @Enumerated(EnumType.STRING)
    var type: Diet,
    @Column(name = "user_history_id")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    var historyId: UUID,
    @Column(name = "food")
    var image: String,
)
