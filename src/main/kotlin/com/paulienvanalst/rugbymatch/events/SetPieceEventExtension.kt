package com.paulienvanalst.rugbymatch.events

import com.paulienvanalst.rugbymatch.team.TeamName

fun List<SetPieceEvent>.wonBy(teamName: TeamName) : List<SetPieceEvent> = this.filter { teamName == it.winningTeam }

fun List<SetPieceEvent>.lostBy(teamName: TeamName) : List<SetPieceEvent> = this.filter { teamName != it.winningTeam }

fun List<SetPieceEvent>.scrumEvents() : List<SetPieceEvent> = this.filter { it is ScrumWasPlayed }

fun List<SetPieceEvent>.lineOutEvents() : List<SetPieceEvent> = this.filter { it is LineOutWasPlayed }