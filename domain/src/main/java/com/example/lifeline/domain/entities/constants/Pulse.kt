package com.example.lifeline.domain.entities.constants

data class Pulse(
    override var userId: Long,
    override var date: String,
    var value: Int
): BioConstant