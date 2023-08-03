package com.example.rickAndMorty.test.presentation.character.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.example.rickAndMorty.test.presentation.character.viewmodel.CharacterViewModel

@Composable
fun DialogScreenOne(showDialog: MutableState<Boolean>, characterViewModel: CharacterViewModel) {

        Dialog(
            onDismissRequest = { cancelClick(showDialog) },
            content = {
                CompleteDialogContent { BodyContent(showDialog, characterViewModel,  "OK") }
            },
            properties = DialogProperties(
                dismissOnBackPress = false,
                dismissOnClickOutside = false
            )
        )

}

@Composable
fun BodyContent(
    dialogState: MutableState<Boolean>,
    characterViewModel: CharacterViewModel,
    okButtonString: String
) {
    Column {

        var nameCharacter by remember { mutableStateOf(TextFieldValue("")) }
        var statusCharacter by remember { mutableStateOf(TextFieldValue("")) }
        var speciesCharacter by remember { mutableStateOf(TextFieldValue("")) }
        var typeCharacter by remember { mutableStateOf(TextFieldValue("")) }
        var genderCharacter by remember { mutableStateOf(TextFieldValue("")) }

        Text(
            text = "Modal de Filtrado",
            fontSize = 18.sp
        )

        OutlinedTextField(value = nameCharacter,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            label = { Text("Character") },
            placeholder = { Text("Character") },
            onValueChange = {
                nameCharacter = it
            }
        )

        OutlinedTextField(value = statusCharacter,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            label = { Text(text = "Status") },
            placeholder = { Text(text = "Alive") },
            onValueChange = {
                statusCharacter = it
            }
        )

        // Outlined Input text with icon on the left
        // inside leadingIcon property add the icon
        OutlinedTextField(
            value = speciesCharacter,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text(text = "Species") },
            placeholder = { Text(text = "Species") },
            onValueChange = {
                speciesCharacter = it
            }
        )

        OutlinedTextField(
            value = typeCharacter,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            label = { Text(text = "Type Character") },
            placeholder = { Text(text = "Type") },
            onValueChange = {
                typeCharacter = it
            }
        )

        // Outlined Text input field with input type number
        // It will open the number keyboard
        OutlinedTextField(value = genderCharacter,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            label = { Text(text = "GenderCharacter") },
            placeholder = { Text(text = "Gender") },
            onValueChange = {
                genderCharacter = it
            }
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxWidth(1f)
                .padding(20.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Button(
                onClick = { cancelClick(dialogState) },
                modifier = Modifier
                    .width(110.dp)
                    .padding(end = 5.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(text = "Close", fontSize = 18.sp)
            }
            Button(
                onClick = {
                    acceptClick(dialogState,characterViewModel,
                    nameCharacter.text, genderCharacter.text,
                    speciesCharacter.text, statusCharacter.text,
                    typeCharacter.text)
                },
                modifier = Modifier.width(70.dp),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(text = okButtonString, fontSize = 18.sp)
            }

        }
    }
}


@Composable
fun CompleteDialogContent(
    content: @Composable () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxHeight(0.9f)
            .fillMaxWidth(0.9f),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(1f)
                .fillMaxHeight(1f),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            AddBody(content)
        }
    }
}


@Composable
private fun AddBody(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .padding(20.dp)
    ) {
        content()
    }
}