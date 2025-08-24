package com.iskportal.dedukt.lsp.method

enum class MethodType(val methodString: String) {
    Cancellation("$/cancelRequest"),
    Progress("$/progress");


    companion object {
        private val stringToMethodTypeMap = values().associateBy(MethodType::methodString)

        // Method to get MethodType from string
        fun fromString(methodString: String): MethodType? {
            return stringToMethodTypeMap[methodString]
        }

        // Method to get string from MethodType
        fun toString(methodType: MethodType): String {
            return methodType.methodString
        }
    }
}
