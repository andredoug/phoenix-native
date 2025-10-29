package com.andre.phoenix.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

// ---------- LOGIN ----------
@Composable
fun LoginScreen(onLogin: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    Column(Modifier.padding(16.dp)) {
        Text("Phoenix Native", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))
        OutlinedTextField(value = email, onValueChange = { email = it }, label = { Text("Email") }, modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(8.dp))
        OutlinedTextField(value = pass, onValueChange = { pass = it }, label = { Text("Senha") },
            visualTransformation = PasswordVisualTransformation(), modifier = Modifier.fillMaxWidth())
        Spacer(Modifier.height(16.dp))
        Button(onClick = onLogin, modifier = Modifier.fillMaxWidth()) { Text("Entrar") }
    }
}

// ---------- DASHBOARD ----------
@Composable
fun DashboardScreen(onOpenOs: () -> Unit) {
    Column(Modifier.padding(16.dp)) {
        Text("Dashboard", style = MaterialTheme.typography.headlineSmall)
        Spacer(Modifier.height(16.dp))
        Card(Modifier.fillMaxWidth()) {
            Column(Modifier.padding(16.dp)) {
                Text("OS Abertas: 8")         // mock
                Text("Máquinas Paradas: 2")   // mock
                Text("MTTR (7d): 01:35 h")    // mock
            }
        }
        Spacer(Modifier.height(16.dp))
        Button(onClick = onOpenOs, modifier = Modifier.fillMaxWidth()) {
            Text("Ver Ordens de Serviço")
        }
    }
}

// ---------- OS LIST ----------
data class OsItem(val id: String, val maquina: String, val defeito: String, val status: String)

@Composable
fun OsListScreen(onBack: () -> Unit) {
    val items = remember {
        listOf(
            OsItem("OS-202510-001", "LK 580T-01", "Vazamento cilindro", "Aberta"),
            OsItem("OS-202510-002", "Prensa Glaumac", "Pressostato desajustado", "Aguard. Material"),
            OsItem("OS-202510-003", "Forno DJ", "Queimou contator", "Finalizada")
        )
    }
    Scaffold(topBar = { TopAppBar(title = { Text("Ordens de Serviço") }) }) { padding ->
        LazyColumn(Modifier.padding(padding)) {
            items(items) { os ->
                Card(Modifier.padding(12.dp).fillMaxWidth()) {
                    Column(Modifier.padding(12.dp)) {
                        Text(os.id, style = MaterialTheme.typography.titleMedium)
                        Text(os.maquina)
                        Text(os.defeito)
                        AssistChip(onClick = {}, label = { Text(os.status) })
                    }
                }
            }
        }
    }
}
