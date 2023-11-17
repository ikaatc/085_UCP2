package com.example.ucp2

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ucp2.data.FormUIState
import com.example.ucp2.data.FormViewModel
import com.example.ucp2.data.SumberData.dospem

enum class PengelolaHalaman {
    Home,
    Formulir,
    Summary
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FormPengajuan(
    viewModel: FormViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold {
        innerPadding -> val uistate by viewModel.stateUI.collectAsState()
        NavHost(
            navController = navController,
            startDestination = PengelolaHalaman.Home.name,
            modifier = Modifier.padding(innerPadding))
        {
            composable(route = PengelolaHalaman.Home.name) {
                HalamanSatu(
                    onSubmitButtonClicked = {navController.navigate(PengelolaHalaman.Formulir.name)}
                )
            }

            composable(route = PengelolaHalaman.Formulir.name){
                val context = LocalContext.current
                HalamanDua(
                    pilihanDosen1 = dospem.map {id -> context.resources.getString(id) },
                    pilihanDosen2 = dospem.map {id -> context.resources.getString(id) },
                    onSelectionChanged1 = {viewModel.setDosen1(it)},
                    onSelectionChanged2 = {viewModel.setDosen2(it)},
                    onNextButtonClicked = {
                        viewModel.setForm(it)
                        navController.navigate(PengelolaHalaman.Summary.name)
                    },
                )
            }

            composable(route = PengelolaHalaman.Summary.name) {
                HalamanTiga(
                    formUIState = uistate,
                    onBackButtonClicked = {cancelOrderAndNavigateToRasa(navController)}
                )
            }
        }
    }
}

private fun cancelOrderAndNavigateToRasa(
    navController: NavHostController) {
    navController.popBackStack(PengelolaHalaman.Formulir.name, inclusive = false)
}
