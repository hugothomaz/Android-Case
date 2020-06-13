package com.hugothomaz.rotafrete.screen.freight.adapter

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.InverseBindingListener
import com.hugothomaz.domain.extensions.noFormatedToDoble
import com.hugothomaz.domain.extensions.removeSymbolMoney
import com.hugothomaz.domain.extensions.toMoney


class MoneyTextWatcher : TextWatcher {

    private var campo: TextView
    private var valorString: String = ""
    private var valorDouble = 0.0
    private var isUpdating = false

    constructor(campo: TextView) {
        this.campo = campo
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, after: Int) {}
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun afterTextChanged(s: Editable?) {
        if (isUpdating) {
            isUpdating = false
            return
        }
        isUpdating = true
        valorString = s.toString()

        try {
            valorDouble = valorString.removeSymbolMoney().noFormatedToDoble()
            valorString = valorDouble.toMoney()

            campo.text = valorString
            if(campo is EditText){
               (campo as EditText).setSelection(valorString.length)
            }

        } catch (e: NumberFormatException) {
            s?.clear()
        }
    }

}