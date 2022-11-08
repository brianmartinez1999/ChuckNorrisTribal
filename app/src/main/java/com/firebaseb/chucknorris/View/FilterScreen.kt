package com.firebaseb.chucknorris.View

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.firebaseb.chucknorris.ViewModel.ViewModelChuckNorris

@Composable
fun FilterScreen(viewModel: ViewModelChuckNorris) {
    val textfilter = remember { mutableStateOf("") }
    val openDropDown = remember { mutableStateOf(false) }
    val listFiler  = viewModel.filter
    Scaffold(
        topBar = {
            TopAppBarChuck()
        }
    ) {
       ContentScreen(
           textfilter = textfilter,
           openDropDown = openDropDown,
           listFiler =  listFiler,
           viewModel = viewModel
       ) 
    }
}

@Composable
fun TopAppBarChuck() {
    TopAppBar() {
        Text(text = "Chucknorris", modifier = Modifier.padding(horizontal = 15.dp))
    }
}

@Composable
fun ContentScreen(
    textfilter: MutableState<String>,
    openDropDown: MutableState<Boolean>,
    listFiler: MutableList<String>,
    viewModel: ViewModelChuckNorris
) {
    Column(modifier = Modifier.padding(20.dp)) {
        TextField(
            enabled = false,
            value = textfilter.value , 
            onValueChange ={},
            placeholder = {
                Text(text = "Selecciona la categoria")
            },
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    openDropDown.value = !openDropDown.value
                }
        )
        DropdownMenu(
            expanded = openDropDown.value,
            modifier = Modifier.fillMaxWidth().padding(15.dp),
            onDismissRequest = {
            openDropDown.value = false
        }) {
            listFiler.forEach {
                Text(
                    text = it, 
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(15.dp)
                        .clickable {
                            textfilter.value = it
                            openDropDown.value = false
                        }
                )
            }
        }
        Button(
            onClick = {
                viewModel.GetJokeRandom(textfilter.value)
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Joke Random")
        }
    }
}


