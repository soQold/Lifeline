package com.example.lifeline.extensions

import com.example.lifeline.R
import com.google.android.material.textfield.TextInputEditText
import com.redmadrobot.inputmask.MaskedTextChangedListener
import com.redmadrobot.inputmask.helper.AffinityCalculationStrategy

fun TextInputEditText.installDecimal2DigitsMask(valueListener: MaskedTextChangedListener.ValueListener? = null) {
    MaskedTextChangedListener.installOn(
        editText = this,
        primaryFormat = context.resources.getString(R.string.format_decimal_2_digits),
        affinityCalculationStrategy = AffinityCalculationStrategy.CAPACITY,
        autocomplete = false,
        autoskip = false,
        valueListener = valueListener
    )
}