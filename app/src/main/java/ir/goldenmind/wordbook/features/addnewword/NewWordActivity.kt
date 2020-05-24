package ir.goldenmind.wordbook.features.addnewword

import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ir.goldenmind.wordbook.R
import ir.goldenmind.wordbook.base.BaseActivity
import ir.goldenmind.wordbook.base.ViewModelFactory
import ir.goldenmind.wordbook.pojo.Word
import kotlinx.android.synthetic.main.activity_new_word.*
import javax.inject.Inject

class NewWordActivity : BaseActivity() {

    lateinit var viewModel: NewWordViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)
        initActionBar(getString(R.string.add_new_word))
        init()
        initButtons()

        viewModel.show()
    }

    private fun init() {

        viewModel = ViewModelProvider(this, this.viewModelFactory).get(NewWordViewModel::class.java)

    }

    private fun initButtons() {
        btnSave.setOnClickListener {
            viewModel.saveNewWordClicked(
                Word(etNewWord.text.toString(), etTranslation.text.toString())
            )
        }
    }

}
