package com.hugothomaz.rotafrete.extensions


fun String.removeSymbolMoney() : String{
    return this.replace("R", "").replace("$", "").replace(",", "").replace(".", "").trim()
}



