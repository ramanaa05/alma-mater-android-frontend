package com.journalia_nitt.journalia_admin_cms.student.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController

import com.journalia_nitt.journalia_admin_cms.student.sharedPreferences.getUserDetails
import com.journalia_nitt.journalia_admin_cms.student.viewModels.bookMarkViewModel
import com.journalia_nitt.journalia_admin_cms.ui.theme.urbanist

@Composable
fun StudentBookMarkScreen(
    navController: NavController) {

    val mode = remember { mutableIntStateOf(1) }


    val bookMarkViewModel: bookMarkViewModel = viewModel()
    val context= LocalContext.current

    LaunchedEffect(Unit) {
        bookMarkViewModel.fetchBookMark(context)
    }
    val posts = bookMarkViewModel.posts.value.data.details

    Column(
        modifier = Modifier.fillMaxSize()
            .padding(30.dp),
    ) {
        Spacer(modifier = Modifier.padding(top = 20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            val color1 = Color(163,127,219)
            val color2 = Color(205,193,255)
            val colorOfFirstCard = remember(mode.intValue) {
                if (mode.intValue == 1) {
                    mutableStateOf(color1)
                } else {
                    mutableStateOf(color2)
                }
            }
            Card(
                modifier = Modifier
                    .size(150.dp, 60.dp)
                    .clickable {

                    },
                colors = CardDefaults.cardColors(colorOfFirstCard.value)
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "ADMIN POSTS",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontFamily = urbanist
                    )
                }
            }
        }
        Spacer(modifier = Modifier.padding(top = 20.dp))
        LazyColumn() {
            items(posts) { item ->
                Spacer(modifier = Modifier.padding(top = 10.dp))
                StudentAdminCard(navController,item)
            }
        }
    }
}
