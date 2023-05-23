package com.space.quiz_app.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User_table")
data class UserEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val userName: String?
)