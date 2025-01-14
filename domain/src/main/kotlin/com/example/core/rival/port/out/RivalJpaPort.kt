package com.example.core.rival.port.out

import com.example.core.rival.dto.RivalSummaryDto
import com.example.core.rival.port.command.RivalEventCommand
import com.example.core.rival.port.query.FindMyRivalByRivalIdQuery
import java.util.UUID

interface RivalJpaPort {
    fun saveRival(memberId: UUID)

    fun refuseFromRivalRequest(command: RivalEventCommand)

    fun requestRival(command: RivalEventCommand)

    fun acceptFromRivalRequest(command: RivalEventCommand)

    fun findMyRivals(memberId: UUID): List<RivalSummaryDto>

    fun findPendingFromMe(memberId: UUID): List<RivalSummaryDto>

    fun findMyRivalByRivalId(query: FindMyRivalByRivalIdQuery): RivalSummaryDto?

    fun findDuplicatedRequestExist(query: FindMyRivalByRivalIdQuery): Boolean
}
