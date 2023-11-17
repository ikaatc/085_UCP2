package com.example.ucp2.data

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FormViewModel : ViewModel() {
    private val _stateUI = MutableStateFlow(FormUIState())
    val stateUI: StateFlow<FormUIState> = _stateUI.asStateFlow()

    fun setDosen1(dosenPem: String) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                dospem1 = dosenPem
            ) }
    }

    fun setDosen2(dosenPem: String) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                dospem2 = dosenPem
            ) }
    }

    fun setForm(listData: MutableList<String>) {
        _stateUI.update { stateSaatIni ->
            stateSaatIni.copy(
                nama = listData[0],
                nim = listData[1],
                konsen = listData[2],
                judul = listData[3]
            )
        }
    }
}