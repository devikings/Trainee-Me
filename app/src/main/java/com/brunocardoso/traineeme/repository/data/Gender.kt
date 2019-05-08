package com.brunocardoso.traineeme.repository.data

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class Gender(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String)