package com.example.empty_project

import kotlin.random.Random

class PasswordGenerator {

    fun generate(
        length: Int,
        digits: Boolean,
        symbols: Boolean,
        uppercase: Boolean
    ): String {

        var charset = "abcdefghijklmnopqrstuvwxyz"

        if (digits) {
            charset += "0123456789"
        }

        if (symbols) {
            charset += "!@#$%^&*()_+-=[]{}"
        }

        if (uppercase) {
            charset += "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        }

        return (1..length)
            .map { charset.random() }
            .joinToString("")
    }
}