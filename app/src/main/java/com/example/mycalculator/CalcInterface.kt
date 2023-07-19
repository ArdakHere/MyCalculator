package com.example.mycalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColor
import java.lang.Appendable
import java.sql.Types.NULL


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun CalcInterface() {
    var textFieldValue by remember { mutableStateOf("") }
    val appleOrange = colorResource(id = R.color.orange)

        Column(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Color.Black)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Black)
                    .height(190.dp)
                    .clickable{}
            )
            Text(
                text = textFieldValue,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                style = TextStyle(
                    fontSize = 45.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Right,
                    color = Color.White
                )
            )

            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    // AC Button
                    Button(text = "AC", Color.Gray) {
                        textFieldValue = ""
                    }
                    // C Button
                    Button(text = "C", Color.Gray) {
                        textFieldValue = textFieldValue.reversed().drop(1).reversed()
                    }
                    // Divide Button

                    Button(text = "%", Color.Gray) {
                        textFieldValue += "%"
                    }
                    // Multiply Button
                    Button(text = "/", appleOrange) {
                        textFieldValue += "/"
                    }
                }

                // Number Buttons
                Column(modifier = Modifier.fillMaxWidth()) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        // Number Buttons: 7, 8, 9
                        Button(text = "7", Color.DarkGray) {
                            textFieldValue += "7"
                        }
                        Button(text = "8", Color.DarkGray) {
                            textFieldValue += "8"
                        }
                        Button(text = "9", Color.DarkGray) {
                            textFieldValue += "9"
                        }
                        Button(text = "X", appleOrange) {
                            textFieldValue += "X"
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        // Number Buttons: 4, 5, 6
                        Button(text = "4", Color.DarkGray) {
                            textFieldValue += "4"
                        }
                        Button(text = "5", Color.DarkGray) {
                            textFieldValue += "5"
                        }
                        Button(text = "6", Color.DarkGray) {
                            textFieldValue += "6"
                        }
                        Button(text = "-", appleOrange) {
                            textFieldValue += "-"
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        // Number Buttons: 1, 2, 3
                        Button(text = "1", Color.DarkGray) {
                            textFieldValue += "1"
                        }
                        Button(text = "2", Color.DarkGray) {
                            textFieldValue += "2"
                        }
                        Button(text = "3", Color.DarkGray) {
                            textFieldValue += "3"
                        }
                        Button(text = "+", appleOrange) {
                            textFieldValue += "+"
                        }
                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        // Number Button: 0
                        Button(text = "()", Color.DarkGray) {
                            textFieldValue += "()"
                        }
                        Button(text = "0", Color.DarkGray) {
                            textFieldValue += "0"
                        }
                        Button(text = ".", Color.DarkGray) {
                            textFieldValue += "."
                        }
                        Button(text = "=", appleOrange) {
                            var num1: String? = null
                            var num2: String? = null
                            var i = 0

                            if (textFieldValue.contains("+")) {
                                while (textFieldValue[i] != '+') {
                                    num1 = (num1 ?: "") + textFieldValue[i]
                                    i++
                                }
                                i++
                                while (i < textFieldValue.length) {
                                    num2 = (num2 ?: "") + textFieldValue[i]
                                    i++
                                }
                                textFieldValue = ""

                                val result = (num1?.toDoubleOrNull() ?: 0.0) + (num2?.toDoubleOrNull() ?: 0.0)
                                textFieldValue += result.toString()
                            }

                            if (textFieldValue.contains("X")) {
                                while (textFieldValue[i] != 'X') {
                                    num1 = (num1 ?: "") + textFieldValue[i]
                                    i++
                                }
                                i++
                                while (i < textFieldValue.length) {
                                    num2 = (num2 ?: "") + textFieldValue[i]
                                    i++
                                }
                                textFieldValue = ""

                                val result = (num1?.toDoubleOrNull() ?: 0.0) * (num2?.toDoubleOrNull() ?: 0.0)
                                textFieldValue += result.toString()
                            }

                            if (textFieldValue.contains("-")) {
                                while (textFieldValue[i] != '-') {
                                    num1 = (num1 ?: "") + textFieldValue[i]
                                    i++
                                }
                                i++
                                while (i < textFieldValue.length) {
                                    num2 = (num2 ?: "") + textFieldValue[i]
                                    i++
                                }
                                textFieldValue = ""

                                val result = (num1?.toDoubleOrNull() ?: 0.0)-(num2?.toDoubleOrNull() ?: 0.0)
                                textFieldValue += result.toString()
                            }
                            if (textFieldValue.contains("/")) {
                                while (textFieldValue[i] != '/') {
                                    num1 = (num1 ?: "") + textFieldValue[i]
                                    i++
                                }
                                i++
                                while (i < textFieldValue.length) {
                                    num2 = (num2 ?: "") + textFieldValue[i]
                                    i++
                                }
                                textFieldValue = ""

                                val result = (num1?.toDoubleOrNull() ?: 0.0)/ (num2?.toDoubleOrNull() ?: 0.0)
                                textFieldValue += result.toString()
                            }

                        }
                    }
                }
            }
        }
    }



@Composable
fun Button(text: String, color: Color, onClick: () -> Unit) {

    Box(
        modifier = Modifier
            .width(80.dp)
            .height(80.dp)
            .padding(5.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(color)
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = text,
            color = Color.White,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
