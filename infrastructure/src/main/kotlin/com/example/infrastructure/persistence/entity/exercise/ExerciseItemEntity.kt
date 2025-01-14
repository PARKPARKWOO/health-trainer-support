package com.example.infrastructure.persistence.entity.exercise

import com.example.infrastructure.common.util.StringListConverter
import com.example.core.exercise.model.ExerciseItem
import jakarta.persistence.Column
import jakarta.persistence.Convert
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

const val EXERCISE_ITEM_TABLE_NAME = "exercise_item"
const val EXERCISE_ITEM_ID = EXERCISE_ITEM_TABLE_NAME + "_id"

@Entity
@Table(name = EXERCISE_ITEM_TABLE_NAME)
class ExerciseItemEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L,
    @Column(name = "exercise_name")
    var exerciseName: String,
    @Column(name = "video_uri", columnDefinition = "TEXT")
    @Convert(converter = StringListConverter::class)
    var videoUri: MutableList<String>,
    @Column(name = "image_uri", columnDefinition = "TEXT")
    @Convert(converter = StringListConverter::class)
    var imageUri: MutableList<String>,
) {
    fun toDomain(): ExerciseItem {
        return ExerciseItem(
            id = id,
            exerciseName = exerciseName,
            videoUrls = videoUri,
            imageUrls = imageUri,
        )
    }
}
