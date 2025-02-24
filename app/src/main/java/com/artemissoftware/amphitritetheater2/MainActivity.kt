package com.artemissoftware.amphitritetheater2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.artemissoftware.amphitritetheater2.custom.CustomScaffoldViewModel
import com.artemissoftware.amphitritetheater2.demo.navigation.DemoNavGraph
import com.artemissoftware.amphitritetheater2.ui.theme.AmphitriteTheater2Theme

class MainActivity : ComponentActivity() {

    private val customScaffoldStateViewModel by viewModels<CustomScaffoldViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AmphitriteTheater2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding)) {
                        DemoNavGraph(
                            customScaffoldStateViewModel = customScaffoldStateViewModel,
                            navController = rememberNavController(),
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AmphitriteTheater2Theme {
        Greeting("Android")
    }
}