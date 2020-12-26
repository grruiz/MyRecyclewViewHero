package com.rafaelgalvezruiz.myrecyclewview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class HeroAdapter : RecyclerView.Adapter<HeroAdapter.ViewHolder>() {
    var superHero: MutableList<SuperHero> = ArrayList()
    private lateinit var context:Context

    //Constructor al que le pasamos una lista y el conexto
    fun HeroAdapter(superHeros: MutableList<SuperHero>,context: Context){
        this.superHero = superHeros
        this.context = context
    }

    //Layout que va a coger
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.item_superhero, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = superHero[position]
        holder.bind(item, context)
    }

    override fun getItemCount(): Int = superHero.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val superheroName = view.findViewById(R.id.tvSuperHeroName) as TextView
        private val realName = view.findViewById(R.id.tvRealName) as TextView
        private val publisher = view.findViewById(R.id.tvPublisher) as TextView
        private val avatar = view.findViewById(R.id.ivAvatar) as ImageView
        fun bind(superhero: SuperHero, context: Context) {
            superheroName.text = superhero.superHeroName
            realName.text = superhero.realName
            publisher.text = superhero.publisher
            itemView.setOnClickListener(View.OnClickListener { Toast.makeText(context, superhero.superHeroName, Toast.LENGTH_SHORT).show() })
            Picasso.get().load(superhero.image).into(avatar)
        }
    }
}