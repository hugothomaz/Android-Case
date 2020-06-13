package com.hugothomaz.domain.extensions


import java.text.DecimalFormat

fun Double.toMoney(pattern: String?=null) : String{
    return getDecimalFormat(pattern).format(this)
}

fun String.moneyToDouble(pattern: String?=null) : Double {
    return getDecimalFormat(pattern).parse(this).toDouble()
}

//remover isso
fun String.noFormatedToDoble() : Double {
    return this.removeSymbolMoney().toDouble() / 100
}

fun String.moneyToInt(pattern: String?=null) : Int {
    return getDecimalFormat(pattern).parse(this).toString().replace(".", "").toInt()
}

fun Int.toMoney(pattern: String?=null) : String {
    return getDecimalFormat(pattern).format(this.toDouble() / 100)
}

private fun getDecimalFormat(pattern: String?): DecimalFormat {
    return pattern?.let {
        DecimalFormat(it)
    } ?: DecimalFormat(getPattern())
}

private fun getPattern(): String {
    val pattern = "R$###,###,###,##0.00"
    return pattern
}


/*
val patterns = "R$###,###,###,##0.00"
val df = DecimalFormat(patterns)

val valorDouble = 505.6
val valorDoubleToMonetarioString = df.format(valorDouble)
val valorStringMonetarioParaDouble = df.parse(valorDoubleToMonetarioString).toDouble()
val valorStringMonetarioParaInt = df.parse(valorDoubleToMonetarioString).toString().replace(".", "").toInt()
val valorIntParaStringMonetario = df.format(valorStringMonetarioParaInt.toDouble() / 10)
val valorDoubleParaStringMonetario = df.format(valorStringMonetarioParaDouble)*/
