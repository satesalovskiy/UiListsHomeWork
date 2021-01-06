package com.homework.uilistshomework

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.NonNull
import androidx.fragment.app.add
import com.google.android.material.tabs.TabLayout
import com.homework.uilistshomework.databinding.ActivityMainBinding
import com.homework.uilistshomework.fragments.FilmsFragment
import com.homework.uilistshomework.fragments.GamesFragment

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        val tmpBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(tmpBinding.root)
        tmpBinding
    }

    @ExperimentalStdlibApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState == null) showNewFragment(tag = "first")

        setupTabLayout()
    }

    private fun setupTabLayout() {
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        changeActiveFragment(hide = "second", show = "first")
                    }
                    1 -> {
                        if (supportFragmentManager.findFragmentByTag("second") != null) {
                            changeActiveFragment(hide = "first", show = "second")
                        } else {
                            showNewFragment(tag = "second", GamesFragment::class.java)
                        }

                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}
            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }

    private fun changeActiveFragment(hide: String, show: String) {
        supportFragmentManager.beginTransaction().apply {
            supportFragmentManager.findFragmentByTag(hide)?.let {
                hide(it)
            }
            supportFragmentManager.findFragmentByTag(show)?.let {
                show(it)
                setPrimaryNavigationFragment(it)
            }
            commit()
        }
    }

    private fun showNewFragment(tag: String, second: Class<GamesFragment>? = null) {
        supportFragmentManager.beginTransaction().apply {
            setReorderingAllowed(true)
            if (second != null) {
                add<GamesFragment>(R.id.fragment_container, tag)

            } else {
                add<FilmsFragment>(R.id.fragment_container, tag)
            }
            commitNow()
        }
        supportFragmentManager.beginTransaction().apply {
            supportFragmentManager.findFragmentByTag(tag)?.let {
                setPrimaryNavigationFragment(it)
            }
            commit()
        }
    }
}
