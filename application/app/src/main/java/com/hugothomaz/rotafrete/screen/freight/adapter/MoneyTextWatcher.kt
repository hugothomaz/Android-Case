package com.hugothomaz.rotafrete.screen.freight.adapter

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.databinding.InverseBindingListener
import com.hugothomaz.rotafrete.extensions.noFormatedToDoble
import com.hugothomaz.rotafrete.extensions.removeSymbolMoney
import com.hugothomaz.rotafrete.extensions.toMoney


class MoneyTextWatcher : TextWatcher {

    private var campo: EditText
    private var valorString: String = ""
    private var valorDouble = 0.0
    private var listener: InverseBindingListener
    private var isUpdating = false


    constructor(campo: EditText, listener: InverseBindingListener) {
        this.campo = campo
        this.listener = listener
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, after: Int) {}
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun afterTextChanged(s: Editable?) {
        listener.onChange()

        if (isUpdating) {
            isUpdating = false
            return
        }
        isUpdating = true

        valorString = s.toString()

        try {
            valorDouble = valorString.removeSymbolMoney().noFormatedToDoble()
            valorString = valorDouble.toMoney()
            campo.setText(valorString)
            campo.setSelection(valorString.length)
        } catch (e: NumberFormatException) {
            s?.clear()
        }
    }

}