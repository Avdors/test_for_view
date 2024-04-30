package com.example.test_for_view

import android.content.Context
import androidx.appcompat.content.res.AppCompatResources

class ChatPreviewRepository {
    fun getChats(context: Context): List<ChatPreview> {
        return buildList {
            val userPhoto = AppCompatResources.getDrawable(context, R.drawable.imt)
            val userName = "Alex Alex"
            val lastMessage = "Hi, how are you?"

            val numberOfChats = (1..10).random()
            for(i in 0..numberOfChats)
                add(ChatPreview(i,userPhoto,userName, lastMessage))
        }

    }
}


