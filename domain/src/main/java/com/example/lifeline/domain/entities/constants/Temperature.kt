package com.example.lifeline.domain.entities.constants

data class Temperature(
    override var userId: Long,
    override var date: String,
    var value: Double
): BioConstant