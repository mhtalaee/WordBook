package ir.goldenmind.wordbook

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import ir.goldenmind.wordbook.base.BaseActivity
import ir.goldenmind.wordbook.features.addnewword.NewWordActivity
import ir.goldenmind.wordbook.features.wordslist.WordsListActivity
//import ir.goldenmind.wordbook.features.addnewword.NewWordActivity
//import ir.goldenmind.wordbook.features.addnewword.NewWordModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : BaseActivity() {

    lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initDrawer()
        initButtons()

    }

    private fun initButtons() {
        vwAddNewWord.setOnClickListener {
            val intentToNewWord = Intent(this, NewWordActivity::class.java)
            startActivity(intentToNewWord)
        }
        vwWordsList.setOnClickListener {
            val intentToWordsList = Intent(this, WordsListActivity::class.java)
            startActivity(intentToWordsList)
        }
    }

    private fun initDrawer() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        drawerToggle = ActionBarDrawerToggle(
            this, drawer_layout,
            R.string.open,
            R.string.close
        )
        drawer_layout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (drawerToggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
