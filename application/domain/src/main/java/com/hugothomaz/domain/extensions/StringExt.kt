package com.hugothomaz.domain.extensions


fun String.removeSymbolMoney() : String{
    return this.replace("R", "").replace("$", "").replace(",", "").replace(".", "").trim()
}



