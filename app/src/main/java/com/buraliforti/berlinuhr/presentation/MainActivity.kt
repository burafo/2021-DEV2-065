package com.buraliforti.berlinuhr.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.buraliforti.berlinuhr.R.id.content_container
import dagger.hilt.android.AndroidEntryPoint

/**
 * Main screen of BerlinUhr application
 */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showBerlinUhrScreen()
    }

    private fun showBerlinUhrScreen() {
        supportFragmentManager.findFragmentByTag(BERLIN_UHR_FRAGMENT_TAG) ?: BerlinUhrFragment
            .newInstance().let {
                supportFragmentManager.beginTransaction()
                    .replace(content_container, it, BERLIN_UHR_FRAGMENT_TAG)
                    .commit()
            }
    }

    companion object {
        private const val BERLIN_UHR_FRAGMENT_TAG = "BerlinUhrFragment"
    }
}