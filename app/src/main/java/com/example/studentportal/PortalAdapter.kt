package com.example.studentportal

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_portal.view.*

class PortalAdapter(val portals: List<Portal>, val clickListener: (Portal) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater  = LayoutInflater.from(parent.context)
        val view = inflater.inflate(
            R.layout.item_portal,
            parent,
            false
        )
        return  PortalViewHolder(view)
    }

    override fun getItemCount() = portals.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PortalViewHolder).bind(portals[position], clickListener)
    }

    class PortalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(portal: Portal, clickListener: (Portal) -> Unit) {
            itemView.ivBtn.text = "${portal.name}\n${portal.link}"
            itemView.setOnClickListener{ clickListener(portal) }
        }
    }
}