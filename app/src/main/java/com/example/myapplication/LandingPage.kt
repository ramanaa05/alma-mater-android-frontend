package com.example.myapplication

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

val poppins = FontFamily(Font(R.font.poppins))
val landingPageButtonTexts = listOf(
    Pair("ADMIN DASHBOARD", Screens.AdminPage.route),
    Pair("POST A DEADLINE" , Screens.DeadlinePage.route),
    Pair("POST ANNOUNCEMENT" , Screens.AnnouncementPage.route)
)

@Composable
fun SplashPage(innerPadding: PaddingValues , navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    navController.navigate(Screens.LandingPage.route)
                },
            colors = CardDefaults.cardColors(Color(163, 127, 219))
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Companion.CenterHorizontally
            ) {
                Text(
                    text = "Alma mater",
                    color = Color.Companion.White,
                    fontFamily = poppins,
                    fontSize = 35.sp
                )
                Spacer(modifier = Modifier.padding(0.dp))
                Text(
                    text = "Admin Interface",
                    color = Color.Companion.White,
                    fontFamily = poppins,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.padding(30.dp))
                Image(
                    painter = painterResource(R.drawable.nittlogo),
                    contentDescription = "Logo",
                    modifier = Modifier.scale(4f)
                )
            }
        }
    }
}

@Composable
fun LandingPage(innerPadding: PaddingValues , navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        Card(
            modifier = Modifier
                .fillMaxSize(),
            colors = CardDefaults.cardColors(Color.Companion.White)
        ) {
            Box() {
                Column(
                    modifier = Modifier
                ) {
                    Spacer(modifier = Modifier.padding(top = 30.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "Alma mater",
                            fontFamily = poppins,
                            fontSize = 32.sp,
                            color = Color.Companion.Black,
                            fontWeight = FontWeight.Companion.Bold
                        )
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ) {
                    IconButton(
                        modifier = Modifier.padding(end = 10.dp, top = 10.dp),
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Image(
                            painter = painterResource(R.drawable.signout),
                            contentDescription = "Sign out button",
                            modifier = Modifier.scale(3f)
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.padding(top = 80.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.nittlogo),
                    contentDescription = "Logo",
                    modifier = Modifier.scale(3.5f)
                )
            }
            Spacer(modifier = Modifier.padding(top = 60.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.Companion.CenterHorizontally
            ) {
                Text(
                    text = "Welcome to Student Welfare ",
                    fontFamily = poppins,
                    fontSize = 20.sp,
                    color = Color.Companion.Black,
                    fontWeight = FontWeight.Companion.Bold
                )
                Text(
                    text = "Dashboard",
                    fontFamily = poppins,
                    fontSize = 20.sp,
                    color = Color.Companion.Black,
                    fontWeight = FontWeight.Companion.Bold
                )
            }
            Spacer(modifier = Modifier.padding(top = 20.dp))
            for (i in landingPageButtonTexts) {
                Spacer(modifier = Modifier.padding(top = 25.dp))
                Card(
                    modifier = Modifier
                        .height(70.dp)
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .clickable {
                            navController.navigate(i.second)
                        }
                        .border(
                            width = 2.dp,
                            color = Color.Companion.Black,
                            shape = RoundedCornerShape(12.dp)
                        ),
                    colors = CardDefaults.cardColors(Color(205, 193, 255))
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.Companion.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = i.first,
                            fontFamily = poppins,
                            fontSize = 20.sp,
                            color = Color.Companion.Black,
                            fontWeight = FontWeight.Companion.Bold
                        )
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(bottom = 20.dp, start = 15.dp, end = 15.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.Companion.Bottom
            ) {
                Card(
                    modifier = Modifier
                        .height(50.dp)
                        .fillMaxWidth()
                        .weight(0.5f),
                    colors = CardDefaults.cardColors(Color(163, 127, 219))
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.Companion.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "POST A QUERY",
                            fontFamily = poppins,
                            fontSize = 20.sp,
                            color = Color.Companion.White,
                            fontWeight = FontWeight.Companion.Bold
                        )
                    }
                }
                Spacer(modifier = Modifier.padding(start = 20.dp))
                Card(
                    modifier = Modifier
                        .height(50.dp)
                        .fillMaxWidth()
                        .weight(0.5f),
                    colors = CardDefaults.cardColors(Color(163, 127, 219))
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.Companion.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = "CONTACT US",
                            fontFamily = poppins,
                            fontSize = 20.sp,
                            color = Color.Companion.White,
                            fontWeight = FontWeight.Companion.Bold
                        )
                    }
                }
            }
        }
    }
}