package com.example.loyaltycard.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.loyaltycard.R
import com.example.loyaltycard.databinding.ActivityMainBinding
import com.google.android.material.appbar.MaterialToolbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setupToolbar()

        //Контроллер который нужен для работы навигации, переходов и т.д.
        navController = (supportFragmentManager.findFragmentById(R.id.fragmentContainerView)
                as NavHostFragment).navController

        //Настраивает нижнюю навигацию, позволяет делать переходы, отображает выбранный пункт меню
        binding.bottomNavigationView.setupWithNavController(navController)

        //Позволяет убрать стрелку назад при переходе с помощью нижней навигации
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.bankCardFragment,
                R.id.discountCardFragment
            )
        )

        //Отображает название фрагментов в экш-баре
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    private fun setupToolbar() {
        val toolbar: MaterialToolbar = binding.materialToolbar
        setSupportActionBar(toolbar)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}