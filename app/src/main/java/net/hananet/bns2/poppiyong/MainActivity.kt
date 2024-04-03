package net.hananet.bns2.poppiyong

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import net.hananet.bns2.poppiyong.Fragment_Home
import net.hananet.bns2.poppiyong.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(binding.mainFragmentContainer.id, Fragment_Home())
            .commit()
    }
}
