package ir.goldenmind.wordbook.features.addnewword

import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import ir.goldenmind.wordbook.R
import ir.goldenmind.wordbook.base.BaseActivity
import ir.goldenmind.wordbook.pojo.Word
import kotlinx.android.synthetic.main.activity_new_word.*
import org.threeten.bp.LocalDateTime


class NewWordActivity : BaseActivity() {

    lateinit var viewModel: NewWordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)

        showToast("hihihihi")

        init()
        initButtons()

    }

    private fun init() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title =
            "${supportActionBar?.title.toString()} ${getString(R.string.hrchy_sign)} ${getString(R.string.add_new_word)}"

        viewModel = ViewModelProvider(this).get(NewWordViewModel::class.java)


    }

    private fun initButtons() {
        btnSave.setOnClickListener {
            viewModel.saveNewWordClicked(
                Word(etNewWord.text.toString(), etTranslation.text.toString(), LocalDateTime.now() )
            )
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
