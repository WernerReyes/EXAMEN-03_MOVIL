package com.reyes.werner.laboratoriocalificado03

import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.reyes.werner.laboratoriocalificado03.databinding.ItemTeacherBinding

class TeacherAdapter(
    var teachers: List<TeacherResponse>
): RecyclerView.Adapter<TeacherAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding = ItemTeacherBinding.bind(itemView)

        fun bind(teacher: TeacherResponse) {
            binding.teacherName.text = teacher.name
            binding.teacherSubject.text = teacher.last_name
            Glide
                .with(itemView)
                .load(teacher.getTeacherImage(teacher.email, teacher.image_url))
                .into(binding.teacherImage)

            itemView.setOnClickListener {
                val dialIntent = Intent(Intent.ACTION_DIAL)
                dialIntent.data = Uri.parse("tel:${teacher.phone_number}")
                itemView.context.startActivity(dialIntent)
            }

            itemView.setOnLongClickListener {
                val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                    data = Uri.parse("mailto:${teacher.email}")
                }
                itemView.context.startActivity(emailIntent)
                true
            }
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemTeacherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view.root)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("Teacher", "Teacher name: ${teachers[position].name}")
        val teacher = teachers[position]
        holder.bind(teacher)
    }

    override fun getItemCount(): Int = teachers.size
}


