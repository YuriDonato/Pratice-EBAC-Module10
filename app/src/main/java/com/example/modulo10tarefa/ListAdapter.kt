package com.example.modulo10

import android.graphics.drawable.Drawable
import android.text.Layout
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.modulo10tarefa.ListItem
import com.example.modulo10tarefa.MainActivity
import com.example.modulo10tarefa.R
import com.example.modulo10tarefa.databinding.ItemBinding

class ListAdapter(
    val listItems: MutableList<ListItem>,
    val listener: MainActivity
): RecyclerView.Adapter<ListAdapter.ListItemViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): ListItemViewHolder{
        return ListItemViewHolder(
            ItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: ListItemViewHolder, position: Int) {
        val item = listItems[position]
        holder.nome.text = item.name
        holder.numero.text = item.phone
        holder.image.setImageResource(item.photo)

        holder.root.setOnClickListener {
            listener.onItemClicked("Você clicou em ${item.name}")
        }
    }

    override fun getItemCount(): Int {
        return listItems.size
    }

    class ListItemViewHolder(binding: ItemBinding): RecyclerView.ViewHolder(binding.root){
        val image = binding.image
        var root = binding.root
        var nome = binding.nome
        var numero = binding.numero
    }

    interface ListAdapterListener{
        fun onItemClicked(content: String)
    }


}

