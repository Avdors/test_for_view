package com.example.test_for_view

import android.graphics.drawable.Drawable

data class ChatPreviewOld(
    val userid: Int,
    val userPhoto: Drawable?,
    val userName: String,
    val lastMessage: String
        )