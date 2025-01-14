package com.example.application.exercise

import com.example.application.exercise.service.ExerciseGoalService
import com.example.core.exercise.port.out.ExerciseGoalJpaPort
import com.example.core.exercise.port.out.ItemGoalRelationshipJpaPort
import com.example.application.exercise.util.ExerciseGoalTestUtil
import io.kotest.core.spec.style.DescribeSpec
import io.mockk.every
import io.mockk.mockk

@Suppress("UnusedPrivateProperty")
class ExerciseGoalDescribe : DescribeSpec(
    {
        val exerciseGoalJpaPort: ExerciseGoalJpaPort = mockk()
        val itemGoalRelationshipJpaPort: ItemGoalRelationshipJpaPort = mockk()
        val exerciseGoalService = ExerciseGoalService(
            exerciseGoalJpaPort = exerciseGoalJpaPort,
            itemGoalRelationshipJpaPort = itemGoalRelationshipJpaPort,
        )
        describe("ExerciseGoal 을 생성할때") {
            context("정상적인 요청이라면") {
                it("Success") {
                    val saveCommand = ExerciseGoalTestUtil.saveExerciseGoalCommand
                    every { exerciseGoalJpaPort.saveExerciseGoal(any()) } returns Unit
                    exerciseGoalService.saveExerciseGoal(saveCommand)
                }
            }
        }
    },
)
