package com.artemissoftware.amphitritetheater2.listswipe

import android.widget.Toast
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitritetheater2.R
import com.artemissoftware.amphitritetheater2.listswipe.composables.ActionIcon
import com.artemissoftware.amphitritetheater2.listswipe.composables.SwipeableItemWithActions
import com.artemissoftware.amphitritetheater2.listswipe.model.Contact
import com.artemissoftware.amphitritetheater2.ui.theme.AmphitriteTheater2Theme

@Composable
fun ListSwipeScreen() {
    val context = LocalContext.current
    val contacts = remember {
        mutableStateListOf(
            *(1..100).map {
                Contact(
                    id = it,
                    name = "Contact $it",
                    isOptionsRevealed = false
                )
            }.toTypedArray()
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        itemsIndexed(items = contacts,  key = { index, item ->  "${item.id}-${index}" }) { index, contact ->
            SwipeableItemWithActions(
                isRevealed = contact.isOptionsRevealed,
                onExpanded = {
                    contacts[index] = contact.copy(isOptionsRevealed = true)
                },
                onCollapsed = {
                    contacts[index] = contact.copy(isOptionsRevealed = false)
                },
                actions = {
                    ActionIcon(
                        onClick = {
                            Toast.makeText(
                                context,
                                context.getString(R.string.contact_was_deleted, contact.id.toString()),
                                Toast.LENGTH_SHORT
                            ).show()
                            contacts.remove(contact)
                        },
                        backgroundColor = Color.Red,
                        icon = Icons.Default.Delete,
                        modifier = Modifier.fillMaxHeight()
                    )
                    ActionIcon(
                        onClick = {
                            contacts[index] = contact.copy(isOptionsRevealed = false)
                            Toast.makeText(
                                context,
                                context.getString(R.string.contact_was_sent_an_email, contact.id.toString()),
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        backgroundColor = Color.Yellow,
                        icon = Icons.Default.Email,
                        modifier = Modifier.fillMaxHeight()
                    )
                    ActionIcon(
                        onClick = {
                            contacts[index] = contact.copy(isOptionsRevealed = false)
                            Toast.makeText(
                                context,
                                context.getString(R.string.contact_was_shared, contact.id.toString()),
                                Toast.LENGTH_SHORT
                            ).show()
                        },
                        backgroundColor = Color.Magenta,
                        icon = Icons.Default.Share,
                        modifier = Modifier.fillMaxHeight()
                    )
                },
            ) {
                Text(
                    text = stringResource(R.string.contact, contact.id),
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ListSwipeScreenPreview() {
    AmphitriteTheater2Theme {
        ListSwipeScreen()
    }
}