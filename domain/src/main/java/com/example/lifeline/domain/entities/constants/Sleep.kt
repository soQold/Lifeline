package com.example.lifeline.domain.entities.constants

data class Sleep(
    override var userId: Long,
    override var date: String,
    var value: Int
) : BioConstant