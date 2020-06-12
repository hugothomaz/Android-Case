package com.hugothomaz.rotafrete.screen.freight.adapter

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener
import com.hugothomaz.rotafrete.extensions.moneyToDouble
import com.hugothomaz.rotafrete.extensions.removeSymbolMoney
import com.hugothomaz.rotafrete.extensions.toMoney

object FreightBindingAdapter {

    //** Double **
    @JvmStatic
    @BindingAdapter(value = ["bindTextDouble"], requireAll = false)
    fun bindTextDouble(
        textView: TextView, textDouble: Double
    ) {
        val oldText = textView.text

        (textDouble / 100).let { text ->
            if (text.toString() != oldText && (text != null || oldText.length != 0)) {
                if (!text.toString().equals(oldText.toString())) {
                    textView.text = text.toString()
                }
            }
        }
    }

    @InverseBindingAdapter(attribute = "bindTextDouble")
    @JvmStatic
    fun getText(textView: TextView): Double {
        if (textView.text.isNotEmpty()) {
            val value = textView.text
            return value.toString().removeSymbolMoney().toDouble()
        } else {
            return 0.0
        }
    }

    @JvmStatic
    @BindingAdapter("bindTextDoubleAttrChanged")
    fun setTextInputDoubleChangeListener(editText: TextView, listener: InverseBindingListener) {
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                listener.onChange()
                p0?.let {
                    if (editText is EditText) {
                        editText.setSelection(p0.length)
                    }
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
    }


    //** Money **
    @JvmStatic
    @BindingAdapter(value = ["app:bindMoney"], requireAll = false)
    fun bindMoney(
        textView: TextView?, textDouble: Double?
    ) {
        if (textView?.text.toString().isNotEmpty()) {
            val oldText = textView?.text.toString().moneyToDouble()
            textDouble.let { textD ->
                if (textD != null || oldText != 0.0) {
                    val money = textDouble?.toMoney()
                    textView?.text = money
                }
            }
        }
    }

    /*@InverseBindingAdapter(attribute = "bindMoney")
    @JvmStatic
    fun getBindMoney(textView: TextView): Double {
        if (textView.text.isNotEmpty()) {
            val value = textView.text.toString()
            return value.removeSymbolMoney().toDouble() / 100
        } else {
            return 0.0
        }
    }

    @JvmStatic
    @BindingAdapter("bindMoneyAttrChanged")
    fun setTextInputMoneyChangeListener(editText: TextView, listener: InverseBindingListener) {
        editText.addTextChangedListener(MoneyTextWatcher(editText, listener))
    }*/


    //** Int **
    @JvmStatic
    @BindingAdapter(value = ["bindTextAxis"], requireAll = false)
    fun setTextInputInt(
        textView: TextView, textInt: Int
    ) {
        val oldText = textView.text
        textInt.let { text ->
            if (text.toString() != oldText && (text != null || oldText.length != 0)) {
                if (!text.toString().equals(oldText.toString())) {
                    textView.text = text.toString()
                }
            }
        }
    }

    @InverseBindingAdapter(attribute = "bindTextAxis")
    @JvmStatic
    fun getTextInputInt(textView: TextView): Int {
        if (textView.text.isNotEmpty()) {
            val value = textView.text
            return value.toString().toInt()
        } else {
            return 0
        }
    }

    @JvmStatic
    @BindingAdapter("bindTextAxisAttrChanged")
    fun setTextInputIntChangeListener(editText: TextView, listener: InverseBindingListener) {
        var isUpdating = false
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(editable: Editable?) {
                if (isUpdating) {
                    isUpdating = false
                    return
                }
                isUpdating = true

                try {
                    val newValueInt = editText.text.toString()
                    val size = newValueInt.length
                    val value = newValueInt[size-1].toString()
                    if(value.matches(Regex("[0-9]"))){
                        editText.setText(value)
                    }
                    editable?.let {
                        if (editText is EditText) {
                            editText.setSelection(value.length)
                        }
                    }
                }catch (e : Exception){
                    e.printStackTrace()
                }

                listener.onChange()

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        })
    }

}