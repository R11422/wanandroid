package com.rj.wanandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.rj.wanandroid.databinding.ActivityMainBinding
import com.ruijie.setting.fragment.SettingTabAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavHostController
    private val _tabData = arrayListOf(
        Triple(R.drawable.menu_main, R.string.home_page, R.id.homeFragment),
        Triple(R.drawable.menu_project, R.string.progect_page, R.id.progectFragment),
        Triple(R.drawable.menu_tree, R.string.square_page, R.id.squareFragment),
        Triple(R.drawable.menu_public, R.string.public_page, R.id.publicFragment),
        Triple(R.drawable.menu_me, R.string.minec_page, R.id.mineFragment))
        var _binding:ActivityMainBinding?=null
    private val mTabAdapter = SettingTabAdapter(_tabData).apply {
        setOnSelectListener { navigation_id ->
            navController.navigate(navigation_id)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding?.root)
        val layoutManager1=LinearLayoutManager(this)
        layoutManager1.orientation=LinearLayoutManager.HORIZONTAL
        _binding?.apply {
            tabLayout?.apply {
                layoutManager = layoutManager1
                adapter = mTabAdapter
            }
        }
        navController = Navigation.findNavController(this,
            R.id.nav_host_fragment) as NavHostController


    }
}