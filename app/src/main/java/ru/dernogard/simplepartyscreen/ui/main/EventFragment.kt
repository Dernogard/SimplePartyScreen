package ru.dernogard.simplepartyscreen.ui.main

import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.distinctUntilChanged
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.event_fragment.*
import ru.dernogard.simplepartyscreen.R
import ru.dernogard.simplepartyscreen.model.Event

internal class EventFragment : Fragment(R.layout.event_fragment) {

    private val mViewModel: EventViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupGuestRecyclerView()
        setupObservables()
    }

    private fun setupGuestRecyclerView() {
        rv_guests_list.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rv_guests_list.adapter = GuestsAdapter()
    }

    override fun onStart() {
        super.onStart()
        mViewModel.loadData()
    }

    private fun setupObservables() {
        mViewModel.eventLive.distinctUntilChanged().observe(viewLifecycleOwner){
            if (it != null) {
                fillEventInfo(it)
            }
        }
    }

    private fun fillEventInfo(event: Event) {
        text_party_title.text = event.title
        val hostNameText = getString(R.string.text_you_was_invited, event.host.name)
        text_host_name.text = hostNameText
        loadHostUserPhoto(event.host.avatarUrl)
        loadPartyLogo(event.logoUrl)

        if (rv_guests_list.adapter is GuestsAdapter) {
            (rv_guests_list.adapter as GuestsAdapter).submitList(event.guests)
        }
    }

    private fun loadPartyLogo(src: String) {
        Glide.with(requireContext())
            .load(src)
            .placeholder(R.drawable.not_found_image)
            .error(R.drawable.not_found_image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .centerCrop()
            .into(image_party_logo)
    }

    private fun loadHostUserPhoto(src: String) {
        Glide.with(requireContext())
            .load(src)
            .placeholder(R.drawable.empty_photo)
            .error(R.drawable.empty_photo)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .circleCrop()
            .into(image_host_photo)
    }

}