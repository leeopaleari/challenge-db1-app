package br.com.fiap.mentora.screens.app.search

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.List
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.fiap.mentora.R
import br.com.fiap.mentora.common.chip.HabilityCard
import br.com.fiap.mentora.common.input.BaseInputField
import br.com.fiap.mentora.network.responses.User
import br.com.fiap.mentora.screens.app.search.state.SearchUiState
import br.com.fiap.mentora.screens.app.search.viewmodel.SearchViewModel
import br.com.fiap.mentora.ui.theme.MontserratMedium
import br.com.fiap.mentora.ui.theme.TextColorPrimary

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    when {
        uiState.isError -> {
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

        uiState.isLoading -> {
            MyCircularProgress()
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, end = 10.dp, top = 15.dp)
    ) {
        TopSearchAndFilter(uiState)

        Spacer(modifier = Modifier.height(20.dp))

        LazyColumn() {
            items(uiState.users) { user ->
                MatchItem(user = user)
            }
        }

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
    }
}

@Composable
private fun TopSearchAndFilter(uiState: SearchUiState) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier.weight(1f)
            ) {
                BaseInputField(
                    onValueChange = {},
                    label = "Pesquise por competência",
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Icon button",
                            tint = TextColorPrimary
                        )
                    }
                )
            }

            Spacer(modifier = Modifier.width(10.dp))

            Button(
                onClick = {
                    uiState.onToggleFilter(!uiState.showFilters)
                    Log.i("SearchScreen", "TopSearchAndFilter: ${uiState.showFilters}")
                },
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent
                ),
                modifier = Modifier
                    .offset(y = 5.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.List,
                    contentDescription = "Botão Filtros",
                    tint = TextColorPrimary,
                )
            }
        }

        AnimatedVisibility(visible = uiState.showFilters) {
            Text(text = "Filtros")
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun MatchItem(user: User) {
    Box(
        modifier = Modifier.padding(bottom = 20.dp)
    ) {
        Card(
            border = BorderStroke(width = 2.dp, color = Color(0xFF012640)),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF021017)
            )
        ) {
            Row(
                modifier = Modifier.padding(16.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.profile_match_img),
                        contentDescription = "",
                        modifier = Modifier.size(60.dp)
                    )
                    Text(text = user.name.split(" ")[0], fontSize = 12.sp)
                }

                Spacer(modifier = Modifier.width(10.dp))

                Column {
                    Text(
                        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt...",
                        color = Color(0xFFFFFFFF),
                        fontFamily = MontserratMedium,
                        fontSize = 12.sp,
                        lineHeight = 17.sp
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    FlowRow(
                        horizontalArrangement = Arrangement.spacedBy(space = 4.dp),
                    ) {
                        user.skills.frontend.plus(user.skills.backend).forEach { it ->
                            HabilityCard(text = it)
                        }
                    }
                }
            }
        }
    }
}