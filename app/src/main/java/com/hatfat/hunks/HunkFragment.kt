package com.hatfat.hunks

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.daprlabs.cardstack.SwipeDeck.SwipeEventCallback
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.hatfat.hunks.databinding.FragmentHunkBinding

class HunkFragment : Fragment() {

    private var _binding: FragmentHunkBinding? = null
    private val binding get() = _binding!!

    private val hunkData = listOf(
        HunkData(R.mipmap.praji, "Praji", 35, "172 Lbs", "Enjoys long walks.", false),
        HunkData(R.mipmap.lennox, "Xamuel Lennox", 41, "176 Lbs", "Don't ask about my day job.", false),
        HunkData(R.mipmap.evax, "Evax", 34, "182 Lbs", "Allergic to cats.  Enjoys galactic golf.", false),
        HunkData(
            R.mipmap.merrejk,
            "Merrejk",
            30,
            "210 Lbs",
            "Less conversation, more food.",
            false
        ),
        HunkData(
            R.mipmap.wullf,
            "Wullf Yularen",
            62,
            "165 Lbs",
            "Imperial Security Bureau.  \"My work is my life.\"",
            false
        ),
        HunkData(
            R.mipmap.desanne,
            "Desanne",
            16,
            "169 Lbs",
            "Demoted to shuttle duty.  Fear of rejection.",
            false
        ),
        HunkData(R.mipmap.piett, "Firmus Piett", 40, "172 Lbs", "Native of Axxila.  Top of his graduating class.", false),
        HunkData(R.mipmap.ozzel, "Kendal Ozzel", 38, "195 Lbs", "Clumsy & Stupid.  Loves surprises.", true),
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
                val hunk = adapter.getItem(position);

                if (hunk.isMatch) {
                    showMatch(hunk)
                }
            }

            override fun cardsDepleted() {
                binding.backButton.visibility = View.VISIBLE
            }

            override fun cardActionDown() {
            }

            override fun cardActionUp() {
            }
        })

        binding.backButton.setOnClickListener {
            findNavController().popBackStack()
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showMatch(data: HunkData) {
        context?.let {
            val inflater = LayoutInflater.from(it)
            val matchView = inflater.inflate(R.layout.match_view, null)
            val matchImageView = matchView.findViewById<ImageView>(R.id.match_imageview)
            matchImageView.setImageResource(data.imageResourceId)

            MaterialAlertDialogBuilder(it, R.style.AlertDialogTheme_Hunk)
                .setIcon(R.mipmap.heart)
                .setView(matchView)
                .setPositiveButton(
                    "Okay"
                ) { p0, p1 -> Log.i("adsfadsf", "sadf") }
                .create()
                .show()
        }
    }
}