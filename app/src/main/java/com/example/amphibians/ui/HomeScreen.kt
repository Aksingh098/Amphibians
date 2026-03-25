package com.example.amphibians.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.amphibians.R
import com.example.amphibians.data.amphibianMockData
import com.example.amphibians.model.Amphibian

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmphibianApp(
    modifier: Modifier = Modifier
){
    Scaffold(
        topBar = {TopAppBar(title = {Text(text = stringResource(R.string.app_title))})}
    ) {innerpadding ->
        HomeScreen(
            modifier = modifier.padding(innerpadding)
        )

    }

}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    amphibians: List<Amphibian> = amphibianMockData

){
    LazyColumn(

    ) {
        items(amphibians){data ->
            AmphibianCard(
                amphibian = data

            )
        }

    }



}

@Composable
fun AmphibianCard(
    modifier: Modifier = Modifier,
    amphibian: Amphibian,

    ){
    Card(
        modifier = modifier.fillMaxWidth().padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(4.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Row() {
                Text(
                    text = amphibian.name ,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = " (" +amphibian.type + ")" ,
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.secondary
                )

            }


            Spacer(modifier = Modifier.height(8.dp))


            Text(
                text = amphibian.description,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Justify
            )
        }
    }

}


