package com.example.core.exercise.application.port.`in`

import com.example.core.exercise.application.port.command.SaveExerciseGoalCommand
import com.example.core.exercise.model.ExerciseGoal

interface ExerciseGoalUseCase {
    fun saveExerciseGoal(command: SaveExerciseGoalCommand)

    fun deleteExerciseGoal(id: Long)

    fun getGoal(id: Long): ExerciseGoal

    fun getAllGoals(): List<ExerciseGoal>
}
