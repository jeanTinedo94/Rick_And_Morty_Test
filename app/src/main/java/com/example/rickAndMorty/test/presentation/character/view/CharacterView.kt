package com.example.rickAndMorty.test.presentation.character.view

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.rickAndMorty.test.R
import com.example.rickAndMorty.test.domain.model.characters.Result
import com.example.rickAndMorty.test.presentation.character.viewmodel.CharacterViewModel

@Composable
fun CharacterViewScreen(characterViewModel: CharacterViewModel = hiltViewModel()){
    val ctx: Context = LocalContext.current
    val res= characterViewModel.characterList.value
    val showDialog = remember { mutableStateOf(false)}

    if(showDialog.value) {
        DialogScreenOne(showDialog,characterViewModel)
    } else {
        Toast.makeText(ctx, "Dialog Closed", Toast.LENGTH_SHORT).show()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Character List")
                },
                actions = {
                    IconButton(onClick = {
                        showDialog.value = !showDialog.value
                    }) {
                        Icon(
                            imageVector = Icons.Rounded.Search,
                            contentDescription = "",
                            tint = Color.White,
                        )
                    }
                },
            )
        },) {
        paddingValues->
        if (res.loading){
            Box(modifier= Modifier
                .fillMaxSize()
                .padding(16.dp), contentAlignment = Alignment.Center){
                CircularProgressIndicator()
            }
        }
        if (res.error.isNotEmpty()){
            Box(modifier= Modifier
                .fillMaxSize()
                .padding(16.dp), contentAlignment = Alignment.Center){
                Text(text= res.error)
            }
        }
        res.data?.results.let {
            LazyColumn(modifier = Modifier
                .padding(paddingValues)
                .background(color = MaterialTheme.colors.primary)){
                it?.let {
                    items(it){
                        //it.episode.first()
                            CharacterRow(data = it)
                        }
                    }
                }
            }
        }

}

fun cancelClick(showDialog: MutableState<Boolean>) {
    showDialog.value= false
}

fun acceptClick(
    showDialog: MutableState<Boolean>,
    characterViewModel: CharacterViewModel,
    nameCharacter: String,
    genderCharacter: String,
    speciesCharacter: String,
    statusCharacter: String,
    typeCharacter: String
) {
    characterViewModel.getFilterCharacters(
        nameCharacter,statusCharacter, speciesCharacter,
        typeCharacter,genderCharacter
    )
    showDialog.value= false
}


fun getColorStatus(status: String): Color {
    return when (status){
        "Alive" -> {
            Color.Green
        }
        "Dead" -> {
            Color.Red
        }
        else -> {Color.LightGray}
    }
}

@Composable
fun CharacterRow(data: Result){
    Card(modifier= Modifier
        .padding(10.dp)
        .fillMaxSize()
        ){
        Row(verticalAlignment = Alignment.CenterVertically,modifier =
        Modifier
            .background(MaterialTheme.colors.secondaryVariant)
            .fillMaxSize()) {
            Image(
                painter = rememberAsyncImagePainter(data.image),
                contentDescription = null,
                modifier = Modifier.size(180.dp)
            )
            Column(modifier = Modifier.padding(start = 12.dp, bottom = 12.dp)) {
                Text(data.name, fontSize = 24.sp, color = Color.White)
                Row(
                    Modifier
                        .fillMaxWidth()
                ){
                    Icon(imageVector = Icons.Rounded.CheckCircle, contentDescription = "Back",
                    tint = getColorStatus(data.status), modifier = Modifier.padding(end = 4.dp))
                    Text(data.status+"-"+data.species,
                        modifier = Modifier.weight(1f),  fontSize = 16.sp, color = Color.White)
                }
                Text( stringResource(id = R.string.last_known), fontSize = 14.sp, color = Color.LightGray)
                Row(
                    Modifier
                        .fillMaxWidth()
                ){
                    Icon(imageVector = Icons.Rounded.LocationOn, contentDescription = "Back",
                        tint = Color.Black, modifier = Modifier.padding(end = 4.dp))
                    Text(data.location.name,  fontSize = 16.sp, color = Color.White)
                }
                Text(stringResource(id = R.string.origin), fontSize = 14.sp, color = Color.LightGray)
                Row(
                    Modifier
                        .fillMaxWidth()
                ){
                    Icon(imageVector = Icons.Rounded.LocationOn, contentDescription = "Back",
                        tint = Color.Black, modifier = Modifier.padding(end = 4.dp))
                    Text(text= data.origin.name, fontSize = 16.sp, color = Color.White)
                }

            }
        }
    }

}
