package com.garv.rockpaperscissorsapp



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GameScreen(paddingValues: PaddingValues = PaddingValues(16.dp), viewModel: GameViewModel) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
            .background(Color.White)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Spacer(modifier = Modifier.height(32.dp))
                Text(
                    text = "\uD83E\uDEA8 Rock \uD83D\uDCC4 Paper ✂️ Scissors",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 22.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(32.dp))
                OutlinedTextField(
                    value = viewModel.computerMove.value?.name ?: "",
                    onValueChange = {},
                    label = { Text("Computer's Move") },
                    modifier = Modifier.fillMaxWidth(),
                    readOnly = true,
                    textStyle = TextStyle(Color.Black)
                )
            }


            Spacer(modifier = Modifier.weight(0.3f))

            Text(
                text = viewModel.result.value,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                color = when(viewModel.result.value) {
                    "🏆 You Won !" -> Color(0xFF2E7D32)
                    "Its A Draw" -> Color(0xFFC62828)
                    else -> Color(0xFF6D4C41)
                },
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
            )

            if(viewModel.result.value.isNotEmpty()) {
                Button(
                    onClick = { viewModel.reset() },
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .height(64.dp)
                ) {
                    Text("🔁 Play Again", fontSize = 18.sp)
                }
            }

            Spacer(modifier = Modifier.weight(0.3f))


            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedTextField(
                    value = viewModel.playerMove.value?.name ?: "",
                    onValueChange = {},
                    label = { Text("Your Move") },
                    modifier = Modifier.fillMaxWidth(),
                    readOnly = true,
                    textStyle = TextStyle(Color.Black)
                )

                Spacer(modifier = Modifier.height(32.dp))
                Button(
                    onClick = { viewModel.getMoves(Move.ROCK) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("\uD83E\uDEA8    Rock   ", fontSize = 20.sp)
                }

                Button(
                    onClick = { viewModel.getMoves(Move.PAPER) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("\uD83D\uDCC4    Paper   ", fontSize = 20.sp)
                }

                Button(
                    onClick = { viewModel.getMoves(Move.SCISSORS) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(64.dp),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text("✂️    Scissors   ", fontSize = 20.sp)
                }

                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}



