package com.example.test_for_view

import android.content.Context
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.DiffUtil

class ChatPreviewRepository {
    fun getChats(context: Context): List<ChatPreview> {
        return buildList {
            val userPhoto = AppCompatResources.getDrawable(context, R.drawable.imt)
            var userName = "Alex Alex"
            val userName2 = "Ivan Ivanov"
            val lastMessage = "Hi, how are you?"
            var userId = 0
            val userId2 = 1
            val numberOfChats = (1..10).random()
            for(i in 0..numberOfChats){
                val randomName = (1..2).random()
                if (randomName == 1){
                    userName = userName2
                    userId = userId2

                }
                    add(ChatPreview(userId,userPhoto,userName, lastMessage))

            }

        }

    }
}


