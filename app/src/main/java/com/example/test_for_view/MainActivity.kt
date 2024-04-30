package com.example.test_for_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class MainActivity : AppCompatActivity() {

    lateinit var chatRecyclerView: RecyclerView
    private val chatPreviewRepository = ChatPreviewRepository()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        chatRecyclerView = findViewById(R.id.rv_chats)
        val chatAdapter = ChatAdapter()
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        chatRecyclerView.adapter = chatAdapter
        chatRecyclerView.layoutManager = layoutManager
        chatRecyclerView.addItemDecoration(ChatPreviewOffsetItemDecoration(bottomOffset = 16f.toInt(), topOffset = 16f.toInt())) //добавляем отступы между элементами
        chatRecyclerView.addItemDecoration(DividerItemDecoration(this, layoutManager.orientation)) // добавляем разделители между элементами
        chatAdapter.chats = chatPreviewRepository.getChats(this)


        val pullTORefresh:SwipeRefreshLayout = findViewById(R.id.pull_to_refresh)
        pullTORefresh.setOnRefreshListener {
            chatAdapter.chats = chatPreviewRepository.getChats(this)
            pullTORefresh.isRefreshing = false
        }
    }
}