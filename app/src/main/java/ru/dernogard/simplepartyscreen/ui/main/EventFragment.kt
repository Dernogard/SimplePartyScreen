package ru.dernogard.simplepartyscreen.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.distinctUntilChanged
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.event_fragment.*
import ru.dernogard.simplepartyscreen.R
import ru.dernogard.simplepartyscreen.model.Event
import ru.dernogard.simplepartyscreen.utils.ImageHelper

/**
 * Screen showing info about the Event
 */

internal class EventFragment : Fragment(R.layout.event_fragment) {

    private val mViewModel: EventViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupGuestRecyclerView()
        setupObservables()
    }

    // List of the guests
    private fun setupGuestRecyclerView() {
        rv_guests_list.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        rv_guests_list.adapter = GuestsAdapter()
    }

    private fun setupObservables() {
        mViewModel.eventLive
            .distinctUntilChanged()
            .observe(viewLifecycleOwner) {
                if (it.title.isNotEmpty() && it.host.name.isNotEmpty()) {
                    label_no_data.visibility = View.INVISIBLE
                    fillEventInfo(it)
                } else {

                    // if data wrong hiding all and show message

                    label_no_data.visibility = View.VISIBLE
                    screen_event_info.visibility = View.INVISIBLE
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
        ImageHelper.loadPartyLogo(image_party_logo, src)
    }

    private fun loadHostUserPhoto(src: String) {
        ImageHelper.loadUserPhoto(image_host_photo, src)
    }

}