package com.droidknights.app2020.ui.schedule

import androidx.recyclerview.widget.DiffUtil
import com.droidknights.app2020.R
import com.droidknights.app2020.common.DataBindingAdapter
import com.droidknights.app2020.common.DataBindingViewHolder
import com.droidknights.app2020.ui.data.SessionData

class ScheduleAdapter : DataBindingAdapter<SessionData>(DiffCallback()) {
    override var itemClickListener: ItemClickListener? = null

    class DiffCallback : DiffUtil.ItemCallback<SessionData>() {
        override fun areItemsTheSame(oldItem: SessionData, newItem: SessionData): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: SessionData, newItem: SessionData): Boolean {
            return oldItem.id == newItem.id
        }
    }

    override fun getItemViewType(position: Int) = R.layout.item_session

    override fun onBindViewHolder(holder: DataBindingViewHolder<SessionData>, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.itemView.setOnClickListener {
            itemClickListener?.onClickItem(getItem(position).id)
        }
    }
}