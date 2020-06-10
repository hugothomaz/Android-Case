package com.hugothomaz.domain.model.enums

enum class OperationPointEnum(val operation : String) {

    OPERATION_START("start"),
    OPERATION_END("end"),
    OPERATION_END_RESUME("end_resume"),
    OPERATION_START_RESUME("end_resume");
}