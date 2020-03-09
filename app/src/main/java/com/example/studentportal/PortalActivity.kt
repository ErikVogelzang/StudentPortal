package com.example.studentportal

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_portal.*

const val PORTAL_EXTRA = "PORTAL_EXTRA"
const val ADD_PORTAL_CODE = 62

class PortalActivity : AppCompatActivity() {

    private val portals = arrayListOf<Portal>()
    private val portalAdapter = PortalAdapter(
        portals,
        { portal: Portal -> portalItemClicked(portal) }
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portal)
        initViews()
    }

    private fun initViews() {
        rvPortals.layoutManager = StaggeredGridLayoutManager(2,
            LinearLayoutManager.VERTICAL)


        for (i in Portal.PORTAL_NAMES.indices) {
            portals.add(Portal(Portal.PORTAL_NAMES[i], Portal.PORTAL_LINKS[i]))
        }

        rvPortals.adapter = portalAdapter
        portalAdapter.notifyDataSetChanged()
        btnAdd.setOnClickListener { onAddClick() }
    }

    private fun portalItemClicked(portal: Portal) {
        val builder = CustomTabsIntent.Builder()
        val customTabsIntent = builder.build()
        customTabsIntent.launchUrl(this, portal.link)
    }

    private fun onAddClick() {
        val addPortalActivityIntent = Intent(this, AddPortalActivity::class.java)
        startActivityForResult(addPortalActivityIntent, ADD_PORTAL_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == ADD_PORTAL_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                val portal = data?.getParcelableExtra<Portal>(PORTAL_EXTRA)
                portals.add(portal!!)
                portalAdapter.notifyDataSetChanged()
            }
        }
    }
}
