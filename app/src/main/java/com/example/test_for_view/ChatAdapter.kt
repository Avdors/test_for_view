package com.example.test_for_view

import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class ChatAdapter: RecyclerView.Adapter<ViewHolder>(), View.OnTouchListener {
    var chats = listOf<Chat>()
        set(value) {
            // field = value
            // notifyDataSetChanged() // это мы добавили чтобы при потягивании вниз список обновился
            // здесь используем DiffUtil, передаем старое новое значение
            val callback = CommonCallbacklmpl(
                oldItems = field,
                newItems = value,
                { oldItem, newItem -> oldItem.id == newItem.id }
            )
            field = value
            val diffREsult = DiffUtil.calculateDiff(callback)
            diffREsult.dispatchUpdatesTo(this)

        }

    class ChatPreviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val userPhoto: ImageView = itemView.findViewById(R.id.image_profil)
        private val userName: TextView = itemView.findViewById(R.id.user_name)
        private val lastMessage: TextView = itemView.findViewById(R.id.last_message)

        fun onBind(chatPreview: ChatPreview) {
            userPhoto.setImageDrawable(chatPreview.userPhoto)
            userName.text = chatPreview.userName
            lastMessage.text = chatPreview.lastMessage
        }
    }

    // холдер для видео чата
    class VideoChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val videoChatName: TextView = itemView.findViewById(R.id.video_chat_name)
        private val numberOfParticipants: TextView =
            itemView.findViewById(R.id.number_of_participants)


        fun onBind(videoChat: VideoChat) {
            videoChatName.text = videoChat.videoChatName
            numberOfParticipants.text = "People:${videoChat.numberOfParticipants}"
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val layoutInflater = LayoutInflater.from(parent.context)
        return when(viewType){
            CHAT_PREVIEW_TYPE->ChatPreviewViewHolder(layoutInflater.inflate(R.layout.chat_item, parent, false))
            VIDEOCHAT_TYPE->VideoChatViewHolder(layoutInflater.inflate(R.layout.video_chat_preview, parent, false))
            else->throw java.lang.IllegalArgumentException("viewType is invalid")
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when(holder){
            is ChatPreviewViewHolder->holder.onBind(chats[position] as ChatPreview)
            is VideoChatViewHolder->holder.onBind(chats[position] as VideoChat)
        }
    }

    override fun getItemCount() = chats.size

    override fun onTouch(p0: View?, p1: MotionEvent?): Boolean {
        TODO("Not yet implemented")
    }

    override fun getItemViewType(position: Int): Int {
        return when(chats[position]) {
            is ChatPreview -> CHAT_PREVIEW_TYPE
            is VideoChat -> VIDEOCHAT_TYPE

        }

    }
    companion object{
        private const val CHAT_PREVIEW_TYPE = 0
        private const val VIDEOCHAT_TYPE = 1
    }

}

