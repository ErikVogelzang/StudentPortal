package com.example.studentportal

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_add_portal.*
import kotlinx.android.synthetic.main.activity_portal.*

class AddPortalActivity : AppCompatActivity() {

 override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_portal)
        initViews()
    }

    private fun initViews() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.add_portal_title)
        btnAddPortal.setOnClickListener { onAddClick() }
    }

    private fun onAddClick() {
        val portal = Portal(
            etTitle.text.toString(),
            Uri.parse(etUri.text.toString())
        )

        val intent = getIntent()
        intent.putExtra(PORTAL_EXTRA, portal)
        setResult(Activity.RESULT_OK, intent)
        finish()
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}
