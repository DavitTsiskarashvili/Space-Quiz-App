package com.space.quiz_app.data.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.room.util.EMPTY_STRING_ARRAY
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

abstract class QuizUserDatastore(private val context: Context) : QuizDatastoreManager<String> {

    private val Context.quizUserdataStore: DataStore<Preferences> by preferencesDataStore(name = "username")
    protected abstract val username: String

    override suspend fun saveValue(value: String) {
        context.quizUserdataStore.edit { preferences ->
            preferences[stringPreferencesKey(username)] = value

        }
    }

    override suspend fun getValue(): Flow<String> {
        val preferences = context.quizUserdataStore.data.map { preference ->
            preference[stringPreferencesKey(username)] ?: ""
        }
        return preferences
    }

}