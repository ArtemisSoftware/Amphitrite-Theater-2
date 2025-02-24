package com.artemissoftware.amphitritetheater2.custom.scaffold

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.artemissoftware.amphitritetheater2.custom.error.ErrorScreen
import com.artemissoftware.amphitritetheater2.custom.error.ErrorState
import com.artemissoftware.amphitritetheater2.ui.theme.AmphitriteTheater2Theme
import kotlinx.coroutines.delay
import kotlin.time.Duration.Companion.seconds

@Composable
fun CustomScaffold(
    content: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    isLoading: Boolean = false,
    errorState: ErrorState? = null,
) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        AnimatedVisibility(
            visible = !isLoading,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Scaffold(
                modifier = Modifier
                    .then(modifier),
                content = { innerPadding ->

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            content.invoke()
                        }
                    }
                },
            )
        }

        if(isLoading)
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )


        errorState?.let {
            ErrorScreen(error = it)
        }
    }
}

@Preview
@Composable
private fun CustomScaffoldPreview() {
    AmphitriteTheater2Theme {

        var isLoading by remember { mutableStateOf(false) }

        LaunchedEffect(isLoading) {
            if(isLoading){
                delay(2.seconds)
                isLoading = !isLoading
            }
        }

        var errorState by remember { mutableStateOf<ErrorState?>(null) }
        val error = ErrorState(
            title = "You arrived at an error screen",
            onFinish = { errorState = null }
        )


        CustomScaffold(
            isLoading = isLoading,
            errorState = errorState,
            content = {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Button(
                        onClick = { isLoading = !isLoading },
                        content = {
                            Text("Toggle is loading")
                        }
                    )
                    Button(
                        onClick = {
                            errorState = error
                        },
                        content = {
                            Text("Toggle error")
                        }
                    )
                }
            },
        )
    }
}