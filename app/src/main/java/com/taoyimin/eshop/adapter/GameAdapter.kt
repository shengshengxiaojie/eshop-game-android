package com.taoyimin.eshop.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.taoyimin.eshop.R
import com.taoyimin.eshop.bean.Game
import com.taoyimin.eshop.i.OnItemClickListener
import com.taoyimin.eshop.i.OnItemLongClickListener

/**
 * Created by Tao Yimin on 2019/5/4.
 */
class GameAdapter(
        private val games: ArrayList<Game>)
    : RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    private var onItemClickListener : OnItemClickListener? = null
    private var onItemLongClickListener : OnItemLongClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            GameViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.adapter_item_game, parent, false))

    override fun getItemCount() = games.size

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        with(holder.itemView) {
            games[position].run {
                holder.titleText.text = title
            }
            setOnClickListener{onItemClickListener?.onItemClick(games[position])}
            setOnLongClickListener{onItemLongClickListener!!.onItemLongClick(games[position], position)}
        }
    }

    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleText: TextView = itemView.findViewById(R.id.text_title)
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener){
        this.onItemClickListener = onItemClickListener
    }

    fun setOnItemLongClickListener(onItemLongClickListener: OnItemLongClickListener){
        this.onItemLongClickListener = onItemLongClickListener
    }
}