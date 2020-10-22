package ru.dernogard.simplepartyscreen.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import ru.dernogard.simplepartyscreen.R
import ru.dernogard.simplepartyscreen.databinding.ItemGuestBinding
import ru.dernogard.simplepartyscreen.model.User

internal class GuestsAdapter : ListAdapter<User, RecyclerView.ViewHolder>(GuestDiffCallback()) {

    internal class GuestDiffCallback : DiffUtil.ItemCallback<User>() {
        override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return GuestHolder(
            ItemGuestBinding
                .inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as GuestHolder).bind(getItem(position))
    }

    inner class GuestHolder(private val binding: ItemGuestBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(user: User) {
            binding.textGuestName.text = user.name
            loadPhoto(user.avatarUrl)
        }

        private fun loadPhoto (src: String) {
            Glide.with(binding.root)
                .load(src)
                .placeholder(R.drawable.empty_photo)
                .error(R.drawable.empty_photo)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .circleCrop()
                .into(binding.imageGuestPhoto)
        }
    }


}