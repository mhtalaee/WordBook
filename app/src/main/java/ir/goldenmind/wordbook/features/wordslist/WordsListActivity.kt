package ir.goldenmind.wordbook.features.wordslist

import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ir.goldenmind.wordbook.R
import ir.goldenmind.wordbook.base.BaseActivity
import ir.goldenmind.wordbook.base.ViewModelFactory
import ir.goldenmind.wordbook.pojo.Word
import kotlinx.android.synthetic.main.activity_words_list.*
import javax.inject.Inject

class WordsListActivity : BaseActivity() {

    private lateinit var viewModel: WordListViewModel
    private lateinit var adapter: WordsListAdapter
    private val list = ArrayList<Word>()
    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_words_list)

        initActionBar(getString(R.string.words_list))
        init()
        initRecyclerView()

    }

    private fun init() {

        viewModel =
            ViewModelProvider(this, this.viewModelFactory).get(WordListViewModel::class.java)

        viewModel.wordCount.observe(this, Observer {
            tvWordCount.text = it.toString()
        })

        viewModel.getCount()

    }

    private fun initRecyclerView() {

        adapter = WordsListAdapter(list) { word: String, translation : String ->
            showToast("$word means $translation")
        }
        rvWordsList.adapter = adapter
        rvWordsList.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

    }

    override fun onResume() {
        super.onResume()
        viewModel.getWordsList()
        viewModel.wordList.observe(this, Observer {
            list.clear()
            list.addAll(it)
            adapter.notifyDataSetChanged()
        })

    }

}