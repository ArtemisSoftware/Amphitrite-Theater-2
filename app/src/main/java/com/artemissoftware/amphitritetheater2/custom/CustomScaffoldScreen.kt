package com.artemissoftware.amphitritetheater2.custom

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.artemissoftware.amphitritetheater2.custom.scaffold.CustomScaffold
import com.artemissoftware.amphitritetheater2.custom.util.events.UiEvent
import com.artemissoftware.amphitritetheater2.ui.theme.AmphitriteTheater2Theme
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

@Composable
fun CustomScaffoldScreen(viewModel: CustomScaffoldViewModel) {
    val state = viewModel.state.collectAsStateWithLifecycle().value
    CustomScaffoldContent(
        state = state,
        uiEvent = viewModel.uiEvent,
        event = viewModel::onTriggerEvent
    )
}

@Composable
private fun CustomScaffoldContent(
    state: CustomScaffoldState,
    event: (CustomScaffoldEvent) -> Unit,
    uiEvent: Flow<UiEvent>
) {

    CustomScaffold(
        uiEvent = uiEvent,
        isLoading = state.isLoading,
        errorState = state.errorState,
        content = {
            Box(modifier = Modifier.fillMaxSize()) {

                Image(
                    painter = painterResource(id = state.image),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .size(200.dp)
                        .clip(CircleShape)
                        .clickable {
                            event.invoke(CustomScaffoldEvent.ChangeImage)
                        }
                )
            }
        }
    )

}

@Preview(showBackground = true)
@Composable
private fun CustomScaffoldScreenPreview() {
    AmphitriteTheater2Theme {
        CustomScaffoldContent(
            state = CustomScaffoldState(),
            event = {},
            uiEvent = flowOf<UiEvent>(),
        )
    }
}