package com.example.menu

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import androidx.annotation.RequiresApi
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.dynamic.DynamicFunction
import com.example.menu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_item1, R.id.nav_item2, R.id.nav_item3
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // Navigation Drawer menü dinamikus funkció használata
        val navMenu: Menu = navView.menu

        val function = DynamicFunction(navMenu)
        Log.i(null, "FUNCTION")

        // Kiválasztott menüelemre listener
        navView.setNavigationItemSelectedListener {
                menuItem ->
            when(menuItem.itemId) {
                R.id.nav_item1 -> {
                    function.clicksMap.computeIfPresent(R.id.nav_item1) { _, v -> v + 1 }
                    function.changeMenuItemsColor(navMenu)
                    //function.changeOrders(navMenu)
                    //function.changeTextSize(navMenu)
                    drawerLayout.closeDrawers()
                }
                R.id.nav_item2 -> {
                    function.clicksMap.computeIfPresent(R.id.nav_item2) { _, v -> v + 1 }
                    function.changeMenuItemsColor(navMenu)
                    //function.changeOrders(navMenu)
                    //function.changeTextSize(navMenu)
                    drawerLayout.closeDrawers()
                }
                R.id.nav_item3 -> {
                    function.clicksMap.computeIfPresent(R.id.nav_item3) { _, v -> v + 1 }
                    function.changeMenuItemsColor(navMenu)
                    //function.changeOrders(navMenu)
                    //function.changeTextSize(navMenu)
                    drawerLayout.closeDrawers()
                }
                R.id.nav_item4 -> {
                    function.clicksMap.computeIfPresent(R.id.nav_item4) { _, v -> v + 1 }
                    function.changeMenuItemsColor(navMenu)
                    //function.changeOrders(navMenu)
                    //function.changeTextSize(navMenu)
                    drawerLayout.closeDrawers()
                }
                R.id.nav_item5 -> {
                    function.clicksMap.computeIfPresent(R.id.nav_item5) { _, v -> v + 1 }
                    function.changeMenuItemsColor(navMenu)
                    //function.changeOrders(navMenu)
                    //function.changeTextSize(navMenu)
                    drawerLayout.closeDrawers()
                }
            }
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.options, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}