package ir.goldenmind.wordbook.features.wordslist

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.goldenmind.wordbook.R
import ir.goldenmind.wordbook.pojo.Word
import kotlinx.android.synthetic.main.word_recycler_view_item.view.*

class WordsListAdapter(
    private var list: List<Word>,
    private var clickListener: (String, String) -> Unit
) :
    RecyclerView.Adapter<WordsListAdapter.WordViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.word_recycler_view_item, parent, false)
        return WordViewHolder(view, clickListener)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holderWord: WordViewHolder, position: Int) {
        holderWord.bind(list[position])
    }

    class WordViewHolder(private val view: View, var clickListener: (String, String) -> Unit) :
        RecyclerView.ViewHolder(view) {

        @SuppressLint("ResourceAsColor")
        fun bind(word: Word) {
            view.tvWord.text = word.word
            view.tvTranslation.text = word.translation

            view.setOnClickListener {
                clickListener(word.word, word.translation)
            }

        }
    }

}