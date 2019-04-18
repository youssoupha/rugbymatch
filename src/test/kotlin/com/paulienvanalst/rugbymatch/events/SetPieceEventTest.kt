package com.paulienvanalst.rugbymatch.events

import com.paulienvanalst.rugbymatch.TeamTestData
import com.paulienvanalst.rugbymatch.game.LineOut
import com.paulienvanalst.rugbymatch.game.Scrum
import com.paulienvanalst.rugbymatch.team.TeamName
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("Ex 2 b and c: inheritance and extension functions")
class SetPieceEventTest {
    @Test
    fun `we can retrieve the set piece events won and lost`() {
        val setPieceEvents = setPieceEvents()
        assertThat(setPieceEvents.wonBy(TeamName.RC_TOULON).size, `is`(6))
        assertThat(setPieceEvents.lostBy(TeamName.WASPS).size, `is`(6))
    }

    @Test
    fun `we can retrieve the scrums`() {
        val setPieceEvents = setPieceEvents()
        assertThat(setPieceEvents.scrumEvents().size, `is`(4))
    }

    @Test
    fun `we can retrieve the line outs`() {
        val setPieceEvents = setPieceEvents()
        assertThat(setPieceEvents.lineOutEvents().size, `is`(4))
    }

    private fun setPieceEvents(): List<SetPieceEvent> {
        val toulon = TeamTestData().validTeam(TeamName.RC_TOULON)
        val wasps = TeamTestData().validTeam(TeamName.WASPS)
        return listOf(
                ScrumWasPlayed(this, scrum = Scrum(toulon, wasps), winningTeam = TeamName.RC_TOULON),
                ScrumWasPlayed(this, scrum = Scrum(toulon, wasps), winningTeam = TeamName.WASPS),
                ScrumWasPlayed(this, scrum = Scrum(toulon, wasps), winningTeam = TeamName.RC_TOULON),
                ScrumWasPlayed(this, scrum = Scrum(toulon, wasps), winningTeam = TeamName.RC_TOULON),
                LineOutWasPlayed(this, lineOut = LineOut(toulon, wasps), winningTeam = TeamName.WASPS),
                LineOutWasPlayed(this, lineOut = LineOut(toulon, wasps), winningTeam = TeamName.RC_TOULON),
                LineOutWasPlayed(this, lineOut = LineOut(toulon, wasps), winningTeam = TeamName.RC_TOULON),
                LineOutWasPlayed(this, lineOut = LineOut(toulon, wasps), winningTeam = TeamName.RC_TOULON)
        )
    }
}