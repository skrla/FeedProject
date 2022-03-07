package skrla.feedproject

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import skrla.feedproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation_view)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        navController = navHostFragment.navController

        bottomNavigation.setupWithNavController(navController)
        setupActionBarWithNavController(navController)

        navController.addOnDestinationChangedListener{_, destination, _ ->
            if (destination.id == R.id.singleAthleteFragment) {
                binding.bottomNavigationView.visibility = View.GONE
                supportActionBar?.show()
                supportActionBar?.title = "Athlete"
            } else if (destination.id == R.id.splashFragment || destination.id == R.id.videoFragment) {
                binding.bottomNavigationView.visibility = View.GONE
                supportActionBar?.hide()

            } else {
                binding.bottomNavigationView.visibility = View.VISIBLE
                supportActionBar?.show()
                supportActionBar?.title = "Feed"
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}