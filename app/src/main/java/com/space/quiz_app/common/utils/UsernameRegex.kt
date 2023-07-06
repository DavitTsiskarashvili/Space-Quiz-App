package com.space.quiz_app.common.utils


/**
Regular expression pattern for validating usernames.
The pattern requires the username to meet the following criteria:
Minimum length of 2 characters
Username should be in Georgian
 */

object UsernameRegex {
    val usernamePattern = "^[ა-ჰ]{3,}\$".toRegex()
}