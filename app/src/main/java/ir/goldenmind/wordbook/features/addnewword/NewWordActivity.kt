package ir.goldenmind.wordbook.features.addnewword

import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import ir.goldenmind.wordbook.R
import ir.goldenmind.wordbook.base.BaseActivity
import ir.goldenmind.wordbook.base.ViewModelFactory
import kotlinx.android.synthetic.main.activity_new_word.*
import javax.inject.Inject


class NewWordActivity : BaseActivity() {

    lateinit var viewModel: NewWordViewModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)

        init()
        initButtons()

        viewModel.newWordSaved.observe(this, Observer { showToast("New word saved!") })

    }

    private fun init() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title =
            "${supportActionBar?.title.toString()} ${getString(R.string.hrchy_sign)} ${getString(R.string.add_new_word)}"

        viewModel = ViewModelProvider(this, viewModelFactory).get(NewWordViewModel::class.java)

    }

    private fun initButtons() {
        btnSave.setOnClickListener {
//            viewModel.saveNewWordClicked(
//                Word(etNewWord.text.toString(), etTranslation.text.toString())
//            )
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> {
                this.finish()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

}
