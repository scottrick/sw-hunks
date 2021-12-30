package com.hatfat.hunks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.hatfat.hunks.databinding.FragmentHunkBinding

class HunkFragment : Fragment() {

    private var _binding: FragmentHunkBinding? = null
    private val binding get() = _binding!!

    private val hunkData = listOf(
        HunkData(R.mipmap.lennox, "Xamuel Lennox", "176 Lbs", "Captain, My Captain"),
        HunkData(R.mipmap.evax, "Evax", "182 Lbs", "The Bulldozer"),
        HunkData(R.mipmap.ozzel, "Kendal Ozzel", "195 Lbs", "Clumsy & Stupid")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHunkBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}