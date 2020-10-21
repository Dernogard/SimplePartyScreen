package ru.dernogard.simplepartyscreen.ui.main

import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.dernogard.simplepartyscreen.R

class EventFragment : Fragment(R.layout.event_fragment) {

    private val viewModel: EventViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeAppBarTitle(R.string.party)
    }


    private fun changeAppBarTitle(@StringRes titleId: Int) {
        val title = resources.getString(titleId)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = title
    }

}