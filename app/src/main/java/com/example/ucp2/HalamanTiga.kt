package com.example.ucp2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ucp2.data.FormUIState

@Composable
fun HalamanTiga(
    formUIState: FormUIState,
    onBackButtonClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    val items = listOf(
        Pair(stringResource(id = R.string.nama), formUIState.nama),
        Pair(stringResource(id = R.string.nim), formUIState.nim),
        Pair(stringResource(id = R.string.konsen), formUIState.konsen),
        Pair(stringResource(id = R.string.judul), formUIState.judul),
        Pair(stringResource(id = R.string.dospem1), formUIState.dospem1),
        Pair(stringResource(id = R.string.dospem2), formUIState.dospem2)
    )
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items.forEach{item ->
                Column {
                    Text(item.first.uppercase())
                    Text(text = item.second.toString(),
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp)
                }

                Divider()

                Spacer(modifier = Modifier.padding(16.dp))
            }
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onBackButtonClicked) {
                Text(stringResource(id = R.string.back))
            }
        }
    }
}