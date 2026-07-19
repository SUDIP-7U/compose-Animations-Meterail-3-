package com.example.jetpackcompose


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WalletAnimation()
        }
    }
}

@Composable
fun BankingScreen() {
    var balance by remember { mutableIntStateOf(0) }
    var inputAmount by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Balance: $balance টাকা",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = inputAmount,
            onValueChange = { inputAmount = it },
            label = { Text("Enter Amount") }
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val amount = inputAmount.toIntOrNull() ?: 0
            balance += amount
            inputAmount = ""
        }) {
            Text("Deposit")
        }
        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = {
            val amount = inputAmount.toIntOrNull() ?: 0
            if (amount <= balance) {
                balance -= amount
            }
            inputAmount = ""
        }) {
            Text("Withdraw")
        }
        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = {
            val amount = inputAmount.toIntOrNull() ?: 0
            if (amount <= balance) {
                balance -= amount
            }
            inputAmount = ""
        }) {
            Text("Spend টাকা")
        }
        Spacer(modifier = Modifier.height(12.dp))

        Button(onClick = { /* Exit action */ }) {
            Text("Exit")
        }
    }
}