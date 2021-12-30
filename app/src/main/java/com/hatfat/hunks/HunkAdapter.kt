package com.hatfat.hunks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class HunkAdapter(private val hunkData: List<HunkData>) :
    BaseAdapter() {

    override fun getCount(): Int {
        return hunkData.size
    }

    override fun getItem(position: Int): HunkData {
        return hunkData[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val hunk = hunkData[position]
        val view = convertView ?: LayoutInflater.from(parent.context)
            .inflate(R.layout.hunk_view, parent, false)

        val nameTextView = view.findViewById<TextView>(R.id.name)
        val imageView = view.findViewById<ImageView>(R.id.profile_image)
        val extraTextView = view.findViewById<TextView>(R.id.extra_text)
        val weightTextView = view.findViewById<TextView>(R.id.weight_text)

        nameTextView.setText(String.format("%s, %d", hunk.name, hunk.age))
        imageView.setImageResource(hunk.imageResourceId)
        extraTextView.setText(hunk.extra)
        weightTextView.setText(hunk.weight)


//        (v.findViewById<View>(R.id.idTVCourseName) as TextView).setText(hunkData[position].getCourseName())
//        (v.findViewById<View>(R.id.idTVCourseDescription) as TextView).setText(
//            hunkData[position].getCourseDescription()
//        )
//        (v.findViewById<View>(R.id.idTVCourseDuration) as TextView).setText(hunkData[position].getCourseDuration())
//        (v.findViewById<View>(R.id.idTVCourseTracks) as TextView).setText(hunkData[position].getCourseTracks())
//        (v.findViewById<View>(R.id.idIVCourse) as ImageView).setImageResource(
//            hunkData[position].getImgId()
//        )

        return view
    }
}
