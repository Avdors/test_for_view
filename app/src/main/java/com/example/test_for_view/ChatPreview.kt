package com.example.test_for_view

import android.graphics.drawable.Drawable
import android.graphics.drawable.Icon

data class ChatPreview(
    val userid: Int,
    val userPhoto: Drawable?,
    val userName: String,
    val lastMessage: String
        )