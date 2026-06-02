package com.example.empty_project

import org.junit.Test
import org.junit.Assert.*

class PasswordGeneratorTest {

    private val generator = PasswordGenerator()

    @Test
    fun password_has_correct_length() {
        val password = generator.generate(12, true, true, true)
        assertEquals(12, password.length)
    }

    @Test
    fun password_contains_digits_when_enabled() {
        val password = generator.generate(12, true, false, false)
        assertTrue(password.any { it.isDigit() })
    }

    @Test
    fun password_contains_uppercase_when_enabled() {
        val password = generator.generate(12, false, false, true)
        assertTrue(password.any { it.isUpperCase() })
    }

    @Test
    fun password_contains_symbols_when_enabled() {
        val password = generator.generate(12, false, true, false)
        val regex = Regex("[^A-Za-z0-9]")
        assertTrue(password.any { regex.matches(it.toString()) })
    }

    @Test
    fun password_is_not_empty() {
        val password = generator.generate(12, true, true, true)
        assertTrue(password.isNotEmpty())
    }
}