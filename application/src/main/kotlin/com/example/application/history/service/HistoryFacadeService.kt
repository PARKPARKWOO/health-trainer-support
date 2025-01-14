package com.example.application.history.service

import com.example.core.history.port.command.AddDietCommand
import com.example.core.history.port.command.AddDietJpaCommand
import com.example.core.history.port.`in`.GenerateHistoryUseCase
import com.example.core.history.port.`in`.HistoryFacadeUseCase
import com.example.core.multimedia.port.`in`.MultimediaUploadUseCase
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class HistoryFacadeService(
    private val multimediaUploadUseCase: MultimediaUploadUseCase,
    private val generateHistoryUseCase: GenerateHistoryUseCase,
) : HistoryFacadeUseCase {
    @Transactional
    override suspend fun addDietToday(command: AddDietCommand) {
        val imageIds = command.images?.let {
            multimediaUploadUseCase.uploadMultipartFiles(it)
        }
        val addDietJpaCommand = AddDietJpaCommand(
            type = command.type,
            todayHistoryId = command.todayHistoryId,
            foods = command.foods,
            images = imageIds,
        )
        generateHistoryUseCase.addDietCommand(addDietJpaCommand)
    }
}
