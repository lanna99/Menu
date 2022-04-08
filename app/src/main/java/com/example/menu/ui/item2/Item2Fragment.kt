package com.example.menu.ui.item2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.menu.R
import com.example.menu.databinding.FragmentItem2Binding

class Item2Fragment : Fragment() {

    private var _binding: FragmentItem2Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val item2ViewModel =
            ViewModelProvider(this).get(Item2ViewModel::class.java)

        _binding = FragmentItem2Binding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textItem2
        item2ViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        _binding!!.buttonPopup.setOnClickListener {
            val popup = PopupMenu(this.activity, _binding!!.buttonPopup)
            val inflater: MenuInflater = popup.menuInflater
            inflater.inflate(R.menu.popup, popup.menu)
            popup.show()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}