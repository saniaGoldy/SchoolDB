package com.example.schooldb

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.schooldb.presentation.navigation.Navigator
import com.example.schooldb.presentation.navigation.NavigatorEvent
import com.example.schooldb.presentation.navigation.destinations.addComposableDestinations
import com.example.schooldb.presentation.navigation.destinations.login.LoginDestination
import com.example.schooldb.ui.theme.SchoolDBTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val navigator: Navigator by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SchoolDBTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BlogNavHost(navigator = navigator)
                }
            }
        }
    }

    @Composable
    fun BlogNavHost(navigator: Navigator) {
        val navController = rememberNavController()

        HandleNavigatorEvents(navController, navigator)

        NavHost(navController = navController, startDestination = LoginDestination.route()) {
            addComposableDestinations(navController)
        }
    }

    @Composable
    private fun HandleNavigatorEvents(
        navController: NavHostController,
        navigator: Navigator
    ) {
        LaunchedEffect(navController) {
            navigator.destinations.collect {
                when (val event = it) {
                    is NavigatorEvent.NavigateUp -> {
                        navController.navigateUp()
                    }
                    is NavigatorEvent.Directions -> navController.navigate(
                        event.destination,
                        event.builder
                    )
                    NavigatorEvent.PopBackStack -> {
                        navController.popBackStack()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SchoolDBTheme {
        Greeting("Android")
    }
}