package com.example.test_for_view


import androidx.recyclerview.widget.DiffUtil
// здесь мы передаем старое количество элементов и новое
// так же проверяем прошлые значения и новые для элементов
class CommonCallbacklmpl<T>(
    private val oldItems:List<T>,
    private val newItems:List<T>,
    private val aretItemTheSampleImpl:(oldItem: T, newItem: T)->Boolean =
        {oldItem, newItem -> oldItem==newItem},
    private val areContentsTheSampleImpl:(oldItem: T, newItem: T)->Boolean =
        {oldItem, newItem -> oldItem==newItem}
): DiffUtil.Callback() {
    override fun getOldListSize() = oldItems.size

    override fun getNewListSize() = newItems.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldItems[oldItemPosition]
        val newItem = newItems[newItemPosition]
        return aretItemTheSampleImpl(oldItem, newItem)
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldItems[oldItemPosition]
        val newItem = newItems[newItemPosition]
        return areContentsTheSampleImpl(oldItem, newItem)
    }
}