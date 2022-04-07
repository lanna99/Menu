package com.example.menu.ui.item1

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.menu.R
import com.example.menu.databinding.FragmentItem1Binding

class Item1Fragment : Fragment() {

    private var _binding: FragmentItem1Binding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val item1ViewModel =
            ViewModelProvider(this).get(Item1ViewModel::class.java)

        _binding = FragmentItem1Binding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textItem1
        item1ViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }

        registerForContextMenu(binding.buttonContext)

        return root
    }

    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        requireActivity().menuInflater.inflate(R.menu.context, menu)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}