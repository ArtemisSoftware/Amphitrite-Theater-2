package com.artemissoftware.amphitritetheater2.dropdownmenu

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitritetheater2.dropdownmenu.composables.PersonItem
import com.artemissoftware.amphitritetheater2.dropdownmenu.model.DropDownItem
import com.artemissoftware.amphitritetheater2.ui.theme.AmphitriteTheater2Theme

@Composable
fun ContextDropDownScreen() {
    val context = LocalContext.current
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(
            listOf(
                "Philipp",
                "Carl",
                "Martin",
                "Jake",
                "Jake",
                "Jake",
                "Jake",
                "Jake",
                "Philipp",
                "Philipp",
            )
        ) {
            PersonItem(
                personName = it,
                dropdownItems = listOf(
                    DropDownItem("Item 1"),
                    DropDownItem("Item 2"),
                    DropDownItem("Item 3"),
                ),
                onItemClick = {
                    Toast.makeText(
                        context,
                        it.text,
                        Toast.LENGTH_LONG
                    ).show()
                },
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PersonItemPreview() {
    AmphitriteTheater2Theme {
        ContextDropDownScreen()
    }
}