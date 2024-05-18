package br.com.fiap.mentora.screens.app.search

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import br.com.fiap.mentora.R
import br.com.fiap.mentora.common.chip.CustomInputChip
import br.com.fiap.mentora.common.chip.HabilityCard
import br.com.fiap.mentora.common.input.BaseInputField
import br.com.fiap.mentora.domain.user.User
import br.com.fiap.mentora.screens.app.search.state.SearchUiState
import br.com.fiap.mentora.screens.app.search.viewmodel.SearchViewModel
import br.com.fiap.mentora.ui.theme.MontserratBold
import br.com.fiap.mentora.ui.theme.MontserratMedium
import br.com.fiap.mentora.ui.theme.MontserratSemiBold
import br.com.fiap.mentora.ui.theme.PrimaryColor
import br.com.fiap.mentora.ui.theme.TextColorPrimary
import br.com.fiap.mentora.ui.theme.TextContrast

@Composable
fun SearchScreen(viewModel: SearchViewModel = hiltViewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    val filteredUsers by viewModel.filteredUsers.collectAsState()

    when {
        uiState.isError -> ErrorBox()
        uiState.isLoading -> MyCircularProgress()
        else -> Content(uiState, filteredUsers, viewModel)
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
private fun TopSearchAndFilter(uiState: SearchUiState, viewModel: SearchViewModel) {
    val frontendSkills = remember { listOf("Html", "Css", "JavaScript", "React", "Vue", "Angular") }
    val backendSkills =
        remember { listOf("Node.js", ".NET", "Python", "Go", "Java", "Spring Boot", "Laravel") }
    val selectedSkills by viewModel.selectedSkills.collectAsState()

    Column(modifier = Modifier.fillMaxWidth()) {
        SearchBar(uiState = uiState, viewModel = viewModel)
        AnimatedVisibility(visible = uiState.showFilters) {
            FilterSection(frontendSkills, backendSkills, selectedSkills, viewModel)
        }
    }
}

@Composable
fun SearchBar(uiState: SearchUiState, viewModel: SearchViewModel) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "MENTORA", fontFamily = MontserratBold, fontSize = 20.sp, color = PrimaryColor)

        Spacer(modifier = Modifier.width(10.dp))

        FilterButton(uiState = uiState)
    }
}

@Composable
fun FilterButton(uiState: SearchUiState) {
    val onToggleFilter = rememberUpdatedState(uiState.onToggleFilter)

    Button(
        onClick = {
            onToggleFilter.value(!uiState.showFilters)
        },
        shape = RoundedCornerShape(5.dp),
        colors = ButtonDefaults.buttonColors(containerColor = if (uiState.showFilters) PrimaryColor else Color.Transparent),
    ) {
        Icon(
            painter = painterResource(id = R.drawable.baseline_filter_list_24),
            contentDescription = "Botão Filtros",
            tint = if (uiState.showFilters) TextContrast else TextColorPrimary,
        )
        Spacer(modifier = Modifier.width(10.dp))
        Text(
            text = "Filtros",
            fontFamily = MontserratSemiBold,
            fontSize = 16.sp,
            color = if (uiState.showFilters) TextContrast else TextColorPrimary
        )

    }
}

@Composable
fun FilterSection(
    frontendSkills: List<String>,
    backendSkills: List<String>,
    selectedSkills: List<String>,
    viewModel: SearchViewModel
) {
    Column(modifier = Modifier.padding(top = 20.dp)) {
        Text(text = "Frontend", Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        SkillChips(
            skills = frontendSkills,
            selectedSkills = selectedSkills,
            onClick = viewModel::onSelectSkill
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = "Backend", Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.height(8.dp))
        SkillChips(
            skills = backendSkills,
            selectedSkills = selectedSkills,
            onClick = viewModel::onSelectSkill
        )
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SkillChips(skills: List<String>, selectedSkills: List<String>, onClick: (String) -> Unit) {
    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        skills.forEach { skill ->
            CustomInputChip(
                text = skill,
                isSelected = selectedSkills.contains(skill),
                onClick = { onClick(skill) }
            )
        }
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
fun Content(uiState: SearchUiState, filteredUsers: List<User>, viewModel: SearchViewModel) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 10.dp, end = 10.dp, top = 15.dp)
    ) {
        TopSearchAndFilter(uiState, viewModel)
        Spacer(modifier = Modifier.height(20.dp))
        UserList(filteredUsers)
    }
}

@Composable
fun UserList(users: List<User>) {
    LazyColumn {
        items(users) { user ->
            MatchItem(user = user)
        }
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun MatchItem(user: User) {
    Box(modifier = Modifier.padding(bottom = 20.dp)) {
        Card(
            border = BorderStroke(width = 2.dp, color = Color(0xFF012640)),
            colors = CardDefaults.cardColors(containerColor = Color(0xFF021017))
        ) {
            Row(modifier = Modifier.padding(16.dp)) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
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
                        text = user.aboutYou,
                        color = Color(0xFFFFFFFF),
                        fontFamily = MontserratMedium,
                        fontSize = 12.sp,
                        lineHeight = 17.sp
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    FlowRow(horizontalArrangement = Arrangement.spacedBy(space = 4.dp)) {
                        user.skills.frontend.plus(user.skills.backend).forEach { skill ->
                            HabilityCard(text = skill)
                        }
                    }
                }
            }
        }
    }
}
