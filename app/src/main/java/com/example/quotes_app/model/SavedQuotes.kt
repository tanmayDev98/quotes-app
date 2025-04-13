package com.example.quotes_app.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "quotes")
data class SavedQuotes(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    var author: String,
    val authorSlug: String,
    val content: String,
    val dateAdded: String,
    val dateModified: String,
    val length: Int,
    val tags: List<String>
)