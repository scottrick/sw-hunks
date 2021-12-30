package com.hatfat.hunks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.daprlabs.cardstack.SwipeDeck.SwipeEventCallback
import com.hatfat.hunks.databinding.FragmentHunkBinding


class HunkFragment : Fragment() {

    private var _binding: FragmentHunkBinding? = null
    private val binding get() = _binding!!

    private val hunkData = listOf(
        HunkData(R.mipmap.lennox, "Xamuel Lennox", 41, "176 Lbs", "Captain, My Captain"),
        HunkData(R.mipmap.evax, "Evax", 34, "182 Lbs", "The Bulldozer"),
        HunkData(R.mipmap.ozzel, "Kendal Ozzel", 38, "195 Lbs", "Clumsy & Stupid")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHunkBinding.inflate(inflater, container, false)

        val adapter = HunkAdapter(hunkData)
        binding.swipeDeck.setAdapter(adapter)
        binding.swipeDeck.setEventCallback(object : SwipeEventCallback {
            override fun cardSwipedLeft(position: Int) {
            }

            override fun cardSwipedRight(position: Int) {
            }

            override fun cardsDepleted() {
            }

            override fun cardActionDown() {
            }

            override fun cardActionUp() {
            }
        })

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}