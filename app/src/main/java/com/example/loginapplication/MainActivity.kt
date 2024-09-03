package com.example.loginapplication

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.loginapplication.ui.theme.LoginApplicationTheme
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LoginApplicationTheme {
                Login()
            }
        }
    }
}

@Composable
fun Login() {

    var email by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    fun resetFields() {
        email = ""
        password = ""
    }

    Column (
        modifier = Modifier.fillMaxSize().padding(horizontal = 32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.androidstudio),
                contentDescription = "Login Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center),
                contentScale = ContentScale.Crop
            )

            Text(
                text = "LOG-IN",
                color = Color.White,
                fontSize = 24.sp,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextField(value = email, modifier = Modifier.fillMaxWidth(), label = {
            Text(text = "Email input")
        }, onValueChange = { email = it })

        Spacer(modifier = Modifier.height(16.dp))

        TextField(value = password, modifier = Modifier.fillMaxWidth(), label = {
            Text(text = "Password input")
        }, onValueChange = { password = it }, visualTransformation = PasswordVisualTransformation())

        Spacer(modifier = Modifier.height(8.dp))

        TextButton(modifier = Modifier.align(Alignment.End), onClick = {  }) {
            Text(text = "Forgot password?", textDecoration = TextDecoration.Underline)
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = {  }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Login")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            Text(text = "Don't have an account?")
            TextButton(onClick = { resetFields() }) {
                Text(text = "Sing-up", textDecoration = TextDecoration.Underline)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Or login with")

        Spacer(modifier = Modifier.height(16.dp))


        Row(modifier = Modifier.fillMaxWidth().padding(horizontal =  40.dp), horizontalArrangement = Arrangement.SpaceEvenly) {
            IconButton(onClick = {  }, Modifier.size(60.dp)) {
                Image(painter = painterResource(id = R.drawable.gmail), contentDescription = "Gmail")
            }

            IconButton(onClick = {  }, Modifier.size(60.dp)) {
                Image(painter = painterResource(id = R.drawable.facebook), contentDescription = "Facebook")
            }
        }

    }
}
