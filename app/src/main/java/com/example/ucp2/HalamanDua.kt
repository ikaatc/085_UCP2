package com.example.ucp2

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HalamanDua(
    pilihanDosen1: List<String>,
    pilihanDosen2: List<String>,
    onSelectionChanged1: (String) -> Unit,
    onSelectionChanged2: (String) -> Unit,
    onNextButtonClicked: (MutableList<String>)->Unit,
    modifier: Modifier = Modifier
) {
    var textNama by rememberSaveable { mutableStateOf("") }
    var textNIM by rememberSaveable { mutableStateOf("") }
    var textKonsen by rememberSaveable { mutableStateOf("") }
    var textJudul by remember { mutableStateOf("") }
    var dosenPembimbing1 by remember { mutableStateOf("") }
    var dosenPembimbing2 by remember { mutableStateOf("") }

    var listData: MutableList<String> = mutableListOf(textNama, textNIM, textKonsen, textJudul)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        OutlinedCard(
            colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
            border = BorderStroke(1.dp, Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 50.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                stringResource(id = R.string.form),
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.padding(16.dp))

            OutlinedTextField(
                value = textNama,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {textNama = it},
                label = {Text(stringResource(id = R.string.nama))}
            )

            Spacer(modifier = Modifier.padding(16.dp))

            OutlinedTextField(
                value = textNIM,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {textNIM = it},
                label = {Text(stringResource(id = R.string.nim))}
            )

            Spacer(modifier = Modifier.padding(16.dp))

            OutlinedTextField(
                value = textKonsen,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {textKonsen = it},
                label = {Text(stringResource(id = R.string.konsen))}
            )

            Spacer(modifier = Modifier.padding(16.dp))

            OutlinedTextField(
                value = textJudul,
                shape = MaterialTheme.shapes.large,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {textJudul = it},
                label = {Text(stringResource(id = R.string.judul))}
            )

            Spacer(modifier = Modifier.padding(16.dp))

            Row {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(stringResource(id = R.string.dospem1))

                    pilihanDosen1.forEach{item ->
                        Row(
                            modifier = Modifier.selectable(
                                selected = dosenPembimbing1 == item,
                                onClick = {
                                    dosenPembimbing1 = item
                                    onSelectionChanged1(item) })
                        ) {
                            RadioButton(
                                selected = dosenPembimbing1 == item,
                                onClick = {
                                    dosenPembimbing1 = item
                                    onSelectionChanged1(item)})
                            Text(item)
                        }
                    }
                }
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(stringResource(id = R.string.dospem1))

                    pilihanDosen2.forEach{item ->
                        Row(
                            modifier = Modifier.selectable(
                                selected = dosenPembimbing2 == item,
                                onClick = {
                                    dosenPembimbing2 = item
                                    onSelectionChanged2(item) })
                        ) {
                            RadioButton(
                                selected = dosenPembimbing2 == item,
                                onClick = {
                                    dosenPembimbing2 = item
                                    onSelectionChanged2(item)})
                            Text(item)
                        }
                    }
                }
            }
            Button(
                enabled = textNama.isNotEmpty() && textNIM.isNotEmpty() && textKonsen.isNotEmpty() && textJudul.isNotEmpty(),
                onClick = { onNextButtonClicked(listData) })
            {
                Text(stringResource(id = R.string.submit))
            }
        }
    }
}


