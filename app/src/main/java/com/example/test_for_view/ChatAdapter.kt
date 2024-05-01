package com.example.test_for_view

import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class ChatAdapter: RecyclerView.Adapter<ChatAdapter.ChatHolder>(), View.OnTouchListener {
    var chats = listOf<ChatPreview>()
    set(value) {
       // field = value
       // notifyDataSetChanged() // это мы добавили чтобы при потягивании вниз список обновился
        // здесь используем DiffUtil, передаем старое новое значение
        val callback = CommonCallbacklmpl(
            oldItems = field,
            newItems = value,
            {oldItem, newItem -> oldItem.userid==newItem.userid}
        )
        field = value
        val diffREsult = DiffUtil.calculateDiff(callback)
        diffREsult.dispatchUpdatesTo(this)

    }

    class ChatHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val userPhoto: ImageView = itemView.findViewById(R.id.image_profil)
        val userName: TextView = itemView.findViewById(R.id.user_name)
        val lastMessage: TextView = itemView.findViewById(R.id.last_message)

        fun onBind(chatPreview: ChatPreview){
            userPhoto.setImageDrawable(chatPreview.userPhoto)
            userName.text = chatPreview.userName
            lastMessage.text = chatPreview.lastMessage
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatAdapter.ChatHolder {
        val layoutInflater=LayoutInflater.from(parent.context)
        return ChatHolder(layoutInflater.inflate(R.layout.chat_item, parent, false))
    }

    override fun onBindViewHolder(holder: ChatAdapter.ChatHolder, position: Int) {
        holder.onBind(chats[position])
    }

    override fun getItemCount() = chats.size

    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        TODO("Not yet implemented")
    }
    }

