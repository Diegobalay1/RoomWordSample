package com.diego.kotlin.roomwordsample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

/**
 * WordListAdapter crea el WordViewHolder en onCreateViewHolder y lo vincula en onBindViewHolder.
 */
class WordListAdapter : ListAdapter<Word, WordListAdapter.WordViewHolder>(WordsComparator()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.word, current.description)
    }

    /**
     * La clase WordViewHolder, que nos permite vincular un texto a un TextView.
     * Esta muestra una función create() estática que controla el aumento del diseño.
     */
    class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val wordItemView: TextView = itemView.findViewById(R.id.textView)
        private val wordItemDescriptionView: TextView = itemView.findViewById(R.id.textView2)

        fun bind(text: String?, text2: String?) {
            wordItemView.text = text
            wordItemDescriptionView.text = text2
        }

        companion object {
            fun create(parent: ViewGroup) : WordViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return WordViewHolder(view)
            }
        }
    }

    /**
     * WordsComparator define cómo calcular si dos palabras son iguales o si los contenidos son los mismos.
     */
    class WordsComparator : DiffUtil.ItemCallback<Word>() {
        override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem.word == newItem.word
        }

    }

}