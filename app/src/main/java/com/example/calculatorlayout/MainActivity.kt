package com.example.calculatorlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.gestures.ScrollableDefaults
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculatorlayout.ui.theme.CalculatorLayoutTheme
import androidx. compose. foundation. layout. RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CalculatorLayoutTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Calculator(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Calculator(modifier: Modifier = Modifier) {
    var numberToShow by remember { mutableStateOf("0") }
    val padding = 8.dp
    val cardModifier = Modifier.padding(padding)
    var componentHeight by remember { mutableStateOf(0.dp) }
    val density = LocalDensity.current
    Column(modifier = modifier.fillMaxSize().verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceEvenly) {
        Card(modifier = cardModifier.fillMaxWidth()) { Text(text = numberToShow, modifier.fillMaxWidth().padding(padding), fontSize = 32.sp, textAlign = TextAlign.Right) }
        Row {
            val cardModifierWithWeight = cardModifier.weight(1f)
            Button(onClick = {}, modifier = cardModifierWithWeight.onGloballyPositioned {
                componentHeight = with(density) {it.size.height.toDp()}
            }) { Text(text = "MC") }
            Button(onClick = {}, modifier = cardModifierWithWeight) { Text(text = "M+") }
            Button(onClick = {}, modifier = cardModifierWithWeight) { Text(text = "M-") }
            Button(onClick = {}, modifier = cardModifierWithWeight) { Text(text = "MR") }
        }
        Row {
            val cardModifierWithWeight = cardModifier.weight(1f)
            Button(onClick = {}, modifier = cardModifierWithWeight) { Text(text = "C") }
            Button(onClick = {}, modifier = cardModifierWithWeight) { Text(text = "+") }
            Button(onClick = {}, modifier = cardModifierWithWeight) { Text(text = "-") }
            Button(onClick = {}, modifier = cardModifierWithWeight) { Text(text = "X") }
        }
        Row {
            val cardModifierWithWeight = cardModifier.weight(1f)
            Button(onClick = {}, modifier = cardModifierWithWeight) { Text(text = "7") }
            Button(onClick = {}, modifier = cardModifierWithWeight) { Text(text = "8") }
            Button(onClick = {}, modifier = cardModifierWithWeight) { Text(text = "9") }
            Button(onClick = {}, modifier = cardModifierWithWeight) { Text(text = "-") }
        }
        Row {
            val cardModifierWithWeight = cardModifier.weight(1f)
            Button(onClick = {}, modifier = cardModifierWithWeight) { Text(text = "4") }
            Button(onClick = {}, modifier = cardModifierWithWeight) { Text(text = "5") }
            Button(onClick = {}, modifier = cardModifierWithWeight) { Text(text = "6") }
            Button(onClick = {}, modifier = cardModifierWithWeight) { Text(text = "+") }
        }
        Row() { // modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceEvenly
            Column(modifier = Modifier.weight(2f)) {
                Row(modifier = Modifier) {
                    val cardModifierWithWeight = cardModifier.weight(1f)
                    Button(onClick = {}, modifier = cardModifierWithWeight) { Text(text = "1") }
                    Button(onClick = {}, modifier = cardModifierWithWeight) { Text(text = "2") }
                }
                Row(modifier = Modifier) {
                    val cardModifierWithWeight = cardModifier.weight(1f)
                    Button(onClick = {}, modifier = cardModifierWithWeight) { Text(text = "0") }
                }
            }
            Column(modifier = Modifier.weight(1f)) {
                val cardModifierWithWeight = cardModifier.fillMaxWidth()
                Button(onClick = {}, modifier = cardModifierWithWeight) { Text(text = "3") }
                Button(onClick = {}, modifier = cardModifierWithWeight) { Text(text = ".") }
            }
            Column(modifier = Modifier.weight(1f)) {
                val cardModifierWithWeight = cardModifier
                    .height(componentHeight * 2 + padding)
                    .fillMaxWidth()
                Button(onClick = {}, modifier = cardModifierWithWeight) { Text(text = "=") }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {
    CalculatorLayoutTheme {
        Calculator()
    }
}