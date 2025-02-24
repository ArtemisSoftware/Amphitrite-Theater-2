package com.artemissoftware.amphitritetheater2.custom

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemissoftware.amphitritetheater2.R
import com.artemissoftware.amphitritetheater2.custom.error.ErrorState
import com.artemissoftware.amphitritetheater2.custom.snackbar.CustomSnackbar
import com.artemissoftware.amphitritetheater2.custom.util.events.UiEvent
import com.artemissoftware.amphitritetheater2.custom.util.events.UiEventViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class CustomScaffoldViewModel: UiEventViewModel() {

    private val _state = MutableStateFlow(CustomScaffoldState())
    val state = _state.asStateFlow()

    private val images = listOf(R.drawable.cdz_1, R.drawable.cdz_2)
    private var index = 0

    fun onTriggerEvent(event: CustomScaffoldEvent){
        when(event){
            CustomScaffoldEvent.ChangeImage -> changeImage()
        }
    }

    private fun changeImage() {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }

            delay(1.seconds)

            if(index >= images.size){
                _state.update {
                    it.copy(
                        isLoading = false,
                        errorState = ErrorState("No Saint found for $index", onFinish = { changeImage() })
                    )
                }
                index = 0
            } else {
                _state.update {
                    it.copy(
                        isLoading = false,
                        image = images[index],
                        errorState = null
                    )
                }
                sendUiEvent(UiEvent.Snackbar(CustomSnackbar.Success("Saint number $index")))
                ++index
            }

        }

    }
}