package com.space.quiz_app.data.datastore

import android.content.Context

class QuizUserDataStoreImpl(context: Context) : QuizUserDatastore(context) {
    override val username: String
        get() = USERNAME

    companion object {
        private const val USERNAME = "username"
    }
}