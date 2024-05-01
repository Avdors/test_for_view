package com.example.test_for_view

import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
// добавляем анимацию обновления списка ресайклер
class ChatAnimator: DefaultItemAnimator(){

    override fun animateAppearance(
        viewHolder: RecyclerView.ViewHolder,
        preLayoutInfo: ItemHolderInfo?,
        postLayoutInfo: ItemHolderInfo
    ): Boolean {
        animateMove(
            viewHolder,
            0,
            0,
            postLayoutInfo.left,
            postLayoutInfo.top
        )
        runPendingAnimations()
        return true
    }
}