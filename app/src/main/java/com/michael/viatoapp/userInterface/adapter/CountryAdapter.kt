package com.michael.viatoapp.userInterface.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.michael.viatoapp.R
import com.michael.viatoapp.userInterface.fragments.CountryOverviewFragment
import com.michael.viatoapp.model.response.Activities
import com.michael.viatoapp.userInterface.activities.MainNavigationActivity

class CountryAdapter(private var activities: MutableList<Activities>) :
    RecyclerView.Adapter<CountryAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return activities.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.nearby_activity_recycler, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val activity = activities[position]

        holder.image.setImageResource(activity.imageUrl)
        holder.description.text = activity.description
        holder.title.text = activity.name
        holder.cardView.setOnClickListener {
            val context = holder.itemView.context
            if (context is MainNavigationActivity) {
                context.navigateToCountryOverviewFragment()
            }
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cardView: CardView = itemView.findViewById(R.id.cardview_activity)
        val image: ImageView = itemView.findViewById(R.id.activity_image)
        val title: TextView = itemView.findViewById(R.id.activity_title)
        val description: TextView = itemView.findViewById(R.id.activity_description)
    }
}