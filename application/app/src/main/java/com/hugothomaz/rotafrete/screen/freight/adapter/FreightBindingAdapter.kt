package com.hugothomaz.rotafrete.screen.freight.adapter

import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.databinding.InverseBindingAdapter
import androidx.databinding.InverseBindingListener

object FreightBindingAdapter {

    //** Double **
    @JvmStatic
    @BindingAdapter(value = ["text"], requireAll = false)
    fun setTextInputDouble(
        textView: TextView, textDouble: Double
    ) {
        val oldText = textView.text
        textDouble?.let {text ->
            if (text.toString() !== oldText && (text != null || oldText.length != 0)) {
                if (text.toString() == oldText) {
                    return
                }
                textView.text = text.toString()
            }
        }

    }

    @InverseBindingAdapter(attribute = "text")
    @JvmStatic
    fun getText(textView: TextView) : Double {
        return textView.text.toString().toDouble()
    }

    @JvmStatic
    @BindingAdapter("textAttrChanged")
    fun setTextInputDoubleChangeListener(editText: TextView, listener: InverseBindingListener) {
        editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) = listener.onChange()

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

        })
    }


    //** Int **

    @JvmStatic
    @BindingAdapter(value = ["text"], requireAll = false)
    fun setTextInputInt(
        textView: TextView, textInt: Int
    ) {
        val oldText = textView.text
        textInt?.let { text ->
            if (text.toString() !== oldText && (text != null || oldText.length != 0)) {
                if (text.toString() == oldText) {
                    return
                }
                textView.text = text.toString()
            }
        }?:textView.setText("0")

    }

    @InverseBindingAdapter(attribute = "text")
    @JvmStatic
    fun getTextInputInt(textView: TextView) : Int {
        if(textView.text.isNotEmpty()){
            val value = textView.text
            return value.toString().toInt()
        }else{
            return 0
        }

    }


}