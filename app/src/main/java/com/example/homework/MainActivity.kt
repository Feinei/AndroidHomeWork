package com.example.homework

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_join.*

class MainActivity : AppCompatActivity(),
    MemberFragment.OnMemberFragmentInteractionListener,
    JoinFragment.OnJoinFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupDrawerContent(nvView)
    }

    override fun onMemberFragmentInteraction() {
        supportFragmentManager.also {
            it.beginTransaction().apply {
                setCustomAnimations(
                    R.anim.enter_from_right,
                    R.anim.exit_to_left,
                    R.anim.enter_from_left,
                    R.anim.exit_to_right
                )
                replace(R.id.flContent, JoinFragment.newInstance())
                addToBackStack(JoinFragment::class.java.name)
                commit()
            }
        }
    }

    override fun onJoinFragmentInteraction() {

        var fragment = JoinedFragment()
        fragment.arguments = Bundle().also {
            it.putString("KEY_NAME", et_name.text.toString())
            it.putString("KEY_AGE", et_age.text.toString())
            it.putString("KEY_STANDING", et_skate_standing.text.toString())
        }

        supportFragmentManager.also {
            it.beginTransaction().apply {
                setCustomAnimations(
                    R.anim.enter_from_below,
                    R.anim.exit_to_above
                )
                replace(R.id.flContent, fragment)
                commit()
            }
        }
    }

    override fun onBackPressed() {

        val fragment = supportFragmentManager.findFragmentById(R.id.flContent)
        (fragment as? OnBackPressedListener)?.onBackPressed()?.let {
            super.onBackPressed()

            supportFragmentManager.also {
                it.popBackStack(JoinFragment::class.java.name, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            }
        }
    }

    private fun setupDrawerContent(navigationView: NavigationView) {
        navigationView.setNavigationItemSelectedListener { menuItem ->
            selectDrawerItem(menuItem)
            true
        }
    }

    private fun selectDrawerItem(menuItem: MenuItem) {

        val fragmentClass: Class<*>
        when (menuItem.itemId) {
            R.id.nav_member_fragment -> fragmentClass = MemberFragment::class.java
            R.id.nav_skate_fragment -> fragmentClass = SkateFragment::class.java
            R.id.nav_roller_fragment -> fragmentClass = RollerFragment::class.java
            R.id.nav_sneaker_fragment -> fragmentClass = SneakerFragment::class.java
            else -> fragmentClass = MemberFragment::class.java
        }

        (fragmentClass.newInstance() as Fragment)?.let {
            supportFragmentManager.beginTransaction().replace(R.id.flContent, it).commit()
        }

        menuItem.isChecked = true
        title = menuItem.title
        drawer_layout.closeDrawers()
    }
}
