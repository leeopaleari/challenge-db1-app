package br.com.fiap.mentora.screens.app.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.fiap.mentora.screens.app.home.components.MatchCard
import br.com.fiap.mentora.screens.app.home.state.HomeUiState
import br.com.fiap.mentora.screens.app.home.viewmodel.HomeViewModel


@SuppressLint("UnrememberedMutableState")
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    when {
        uiState.isError -> ErrorBox()
        uiState.isLoading -> MyCircularProgress()
        else -> Content(uiState)
    }
}

@Composable
fun MyCircularProgress() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0x80222222))
            .zIndex(2f),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier.size(80.dp)
        )
        Text("Buscando mentores..", modifier = Modifier.offset(y = 55.dp))
    }
}

@Composable
fun ErrorBox() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.Red)
    ) {
        Text(
            text = "Falha ao buscar o endereço",
            Modifier
                .padding(8.dp)
                .align(Alignment.Center),
            color = Color.White
        )
    }
}


@Composable
fun Content(uiState: HomeUiState) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        var indexToRender by remember {
            mutableIntStateOf(0)
        }

        uiState.users.forEachIndexed { index, item ->
            AnimatedVisibility(
                visible = index == indexToRender,
            ) {
                MatchCard(
                    user = item,
                    onLike = {
                        indexToRender += 1
                        Log.i("HOME", indexToRender.toString())
                    },
                    onDislike = {

                    }
                )
            }
        }
    }
}