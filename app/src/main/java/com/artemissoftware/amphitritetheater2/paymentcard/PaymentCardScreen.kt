package com.artemissoftware.amphitritetheater2.paymentcard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitritetheater2.R
import com.artemissoftware.amphitritetheater2.paymentcard.composables.InputItem
import com.artemissoftware.amphitritetheater2.paymentcard.composables.PaymentCard
import com.artemissoftware.amphitritetheater2.ui.theme.AmphitriteTheater2Theme

@Composable
fun PaymentCardScreen() {
    var nameText by remember { mutableStateOf("") }
    var cardNumber by remember { mutableStateOf("") }
    var expiryNumber by remember { mutableStateOf("") }
    var cvcNumber by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize()) {
        PaymentCard(
            nameText,
            cardNumber,
            expiryNumber,
            cvcNumber
        )
        LazyColumn(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            item {
                InputItem(
                    text = nameText,
                    label = stringResource(id = R.string.card_holder_name),
                    onTextChanged = { nameText = it },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)
                )
            }

            item {
                InputItem(
                    text = cardNumber,
                    label = stringResource(id = R.string.card_holder_number),
                    keyboardType = KeyboardType.Number,
                    onTextChanged = { cardNumber = it },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
                    visualTransformation = CreditCardFilter
                )
            }

            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    InputItem(
                        text = expiryNumber,
                        label = stringResource(id = R.string.expiry_date),
                        keyboardType = KeyboardType.Number,
                        onTextChanged = { expiryNumber = it },
                        modifier = Modifier.weight(1f)
                            .padding(end = 8.dp)
                    )
                    InputItem(
                        text = cvcNumber,
                        label = stringResource(id = R.string.cvc),
                        keyboardType = KeyboardType.Number,
                        onTextChanged = { cvcNumber = it },
                        modifier = Modifier.weight(1f)
                            .padding(start = 8.dp)
                    )
                }
            }

            item {
                Button(
                    onClick = { },
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp)
                ) {
                    Text(
                        text = stringResource(id = R.string.save),
                        color = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.padding(horizontal = 30.dp, vertical = 8.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PaymentCardScreenPreview() {
    AmphitriteTheater2Theme {
        PaymentCardScreen()
    }
}