package com.example.test_for_view

import android.graphics.drawable.Drawable

sealed class Chat(
    val id: Int
)

data class ChatPreview(
    val userid: Int,
    val userPhoto: Drawable?,
    val userName: String,
    val lastMessage: String

): Chat(id = userid)

data class VideoChat(
    val videoChatid: Int,
    val videoChatName: String,
    val numberOfParticipants: Int

): Chat(videoChatid)