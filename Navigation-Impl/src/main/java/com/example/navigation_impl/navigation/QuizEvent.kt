package com.example.navigation_impl.navigation

/**
 * Used as a wrapper for data that is exposed via a LiveData that represents an event.
 */
open class QuizEvent<out T>(private val content: T) {

    private var hasBeenHandled = false

    /**
     * Returns the content and prevents its use again.
     */
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

}