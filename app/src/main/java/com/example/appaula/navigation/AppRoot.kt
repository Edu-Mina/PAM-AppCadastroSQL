package com.example.appaula.navigation

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.firebase.Firebase
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.composable
import com.example.appaula.ui.screen.HomeScreen
import com.example.appaula.ui.screen.InsertScreen
import com.google.firebase.firestore.firestore

@Composable
fun AppRoot() {
    val focusManager = LocalFocusManager.current

    // Wrapper (Scaffold)
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        appCadastro()
    }
}

@Composable
fun appCadastro() {
    var nome by remember { mutableStateOf("") }
    var rg by remember { mutableStateOf("") }
    var idade by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var endereco by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Column(
        Modifier
            .background(Color.Unspecified)
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .padding(30.dp),
            Arrangement.Center
        ) {
            Text("App Cadastro", fontFamily = FontFamily.Cursive, fontSize = 25.sp)
        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(15.dp),
            Arrangement.Center
        ) {
            TextField(
                value = nome,
                onValueChange = {nome = it},
                label = { Text("Nome") }
            )
        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(15.dp),
            Arrangement.Center
        ) {
            TextField(
                value = rg,
                onValueChange = {rg = it},
                label = { Text("RG") }
            )
        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(15.dp),
            Arrangement.Center
        ) {
            TextField(
                value = idade,
                onValueChange = {idade = it},
                label = { Text("Idade") }
            )
        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(15.dp),
            Arrangement.Center
        ) {
            TextField(
                value = telefone,
                onValueChange = {telefone = it},
                label = { Text("Telefone") }
            )
        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(15.dp),
            Arrangement.Center
        ) {
            TextField(
                value = endereco,
                onValueChange = {endereco = it},
                label = { Text("Endereço") }
            )
        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(15.dp),
            Arrangement.Center
        ) {
            TextField(
                value = email,
                onValueChange = {email = it},
                label = { Text("Email") }
            )
        }

        Row(
            Modifier
                .fillMaxWidth()
                .padding(15.dp),
            Arrangement.Center
        ) {
            Button(
                onClick = {
                    val db = Firebase.firestore

                    val user = hashMapOf(
                        "nome" to nome,
                        "idade" to idade,
                        "rg" to rg,
                        "telefone" to telefone,
                        "endereco" to endereco,
                        "email" to email
                    )
                    db.collection("user")
                        .add(user)
                        .addOnSuccessListener { documentReference ->
                            Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")

                            nome = ""
                            idade = ""
                            rg = ""
                            telefone = ""
                            endereco = ""
                            email = ""
                        }
                        .addOnFailureListener { e ->
                            Log.w(TAG, "Error adding document", e)
                        }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)

            ) {
                Text("Cadastro", fontSize = 25.sp)
            }
        }
    }
}

