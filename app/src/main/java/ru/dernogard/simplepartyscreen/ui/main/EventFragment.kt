package ru.dernogard.simplepartyscreen.ui.main

import android.os.Bundle
import android.view.View
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.distinctUntilChanged
import kotlinx.android.synthetic.main.event_fragment.*
import ru.dernogard.simplepartyscreen.R

internal class EventFragment : Fragment(R.layout.event_fragment) {

    private val mViewModel: EventViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeAppBarTitle(R.string.party)
        setupObservables()
    }

    override fun onStart() {
        super.onStart()
        mViewModel.loadData()
    }

    private fun setupObservables() {
        mViewModel.eventLive.distinctUntilChanged().observe(viewLifecycleOwner){
            if (it == null) {
                changeNoDataLabelVisibility(true)
            }
            else {
                changeNoDataLabelVisibility(false)
            }
        }
    }

    private fun changeNoDataLabelVisibility(isShow: Boolean) {
        progress_bar.visibility = isShow.toViewVisibility()
        message.visibility = isShow.toViewVisibility()
    }

    private fun changeAppBarTitle(@StringRes titleId: Int) {
        val title = resources.getString(titleId)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = title
    }

}

// show view if boolean is true
private fun Boolean.toViewVisibility(): Int {
    return if (this) View.VISIBLE else View.INVISIBLE
}