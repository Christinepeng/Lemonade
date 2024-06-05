package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    var result by remember {
        mutableStateOf(1)
    }
    val imageResourse = when (result) {
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        else -> R.drawable.lemon_restart
    }
    val stringResourse = when (result) {
        1 -> R.string.tap_the_lemon_tree_to_select_a_lemon
        2 -> R.string.keep_tapping_the_lemon_to_squeeze_it
        3 -> R.string.tap_the_lemonade_to_drink_it
        else -> R.string.tap_the_empty_glass_to_start_again
    }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(200.dp) // Size of the background square
                .background(
                    color = Color(0xFFD1EEC6),
                    shape = RoundedCornerShape(16.dp)
                ) // Light green color with rounded corners
                .padding(16.dp) // Padding inside the background box
                .clickable {
                    // Update the state variables when the image is clicked
                    result = (result % 4) + 1
                }
        ) {
            Image(
                painter = painterResource(imageResourse),
                contentDescription = stringResource(stringResourse)
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(stringResourse),
            fontSize = 18.sp,
            modifier = modifier
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        Greeting()
    }
}