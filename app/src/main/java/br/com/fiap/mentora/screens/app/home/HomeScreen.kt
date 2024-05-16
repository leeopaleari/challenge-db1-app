package br.com.fiap.mentora.screens.app.home

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import br.com.fiap.mentora.screens.app.home.components.MatchCard


@SuppressLint("UnrememberedMutableState")
@Composable
fun HomeScreen(

) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        var indexToRender by remember {
            mutableIntStateOf(0)
        }
        val items = remember {
            listOf("Leonardo", "Jade", "Divanildo")
        }


        items.forEachIndexed { index, item ->
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