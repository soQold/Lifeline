package com.example.lifeline.domain.entities.constants

data class Pressure(
    override var userId: Long,
    override var date: String,
    var valueSystolic: Int,
    var valueDiastolic: Int
): BioConstant