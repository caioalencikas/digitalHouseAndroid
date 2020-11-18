package com.caioal.exercicologinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

const val SIGNIN_FRAGMENT = 0
const val SIGNUP_FRAGMENT = 1

class MainActivity : AppCompatActivity(), IChangeTab  {

    private val tab by lazy { findViewById<TabLayout>(R.id.tabLayout) }

    private lateinit var signinFragment: SignInFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pager = findViewById<ViewPager>(R.id.viewPager)

        tab.setupWithViewPager(pager)

        signinFragment = SignInFragment()

        val fragments =  listOf(
            signinFragment
            , SignUpFragment()
        )

        val titulos = listOf(
            getString(R.string.signIn), getString(R.string.signUp)
        )

        pager.adapter = ViewPageAdapter(fragments, titulos, supportFragmentManager)
    }

    override fun changeTab(posicaoAtual: Int) {
        val novaPosicao = if (posicaoAtual == SIGNIN_FRAGMENT) {
            SIGNUP_FRAGMENT
        } else {
            SIGNIN_FRAGMENT
        }

        val tabNova = tab.getTabAt(novaPosicao)
        tabNova?.select()
    }

    override fun userNameChanged(username: String) {
        signinFragment.userNameChanged(username)
    }

}