package com.artemissoftware.amphitritetheater2.demo

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.artemissoftware.amphitritetheater2.R
import com.artemissoftware.amphitritetheater2.demo.composables.Demo
import com.artemissoftware.amphitritetheater2.demo.navigation.Destination

@Composable
fun DemoSelectorScreen(
    navController: NavHostController,
) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = stringResource(id = R.string.demos),
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                fontSize = 28.sp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 8.dp),
            )
        }
        items(Destination.demos) { route ->
            Demo(
                title = route.title,
                modifier = Modifier
                    .fillMaxWidth(),
                onClick =  {
                    navController.navigate(Destination.getRoute(route))
                } ,
            )
        }
    }
}