package ant.realitresonance.clamness.presentation.doctor_screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ant.realitresonance.clamness.presentation.doctor_screen.models.Patient

@Composable
fun PatientItem(
    patient: Patient,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        shape = RoundedCornerShape(0.dp),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Аватар пациента (серый кружок или фото)
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray)
            ) {
                if (patient.hasPhoto) {
                    // Если у пациента есть фото, показываем его
                    Image(
                        painter = ColorPainter(Color.Gray), // Заглушка для фото
                        contentDescription = "Patient Photo",
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Информация о пациенте
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = patient.name,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )

                Text(
                    text = "Lorem ipsum dolor sit",
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }

            Column(
                horizontalAlignment = Alignment.End
            ) {
                if (patient.id == 1) {
                    // Кнопка "Открыть" для первого пациента
                    Button(
                        onClick = onClick,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF2196F3)
                        ),
                        shape = RoundedCornerShape(16.dp),
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 6.dp)
                    ) {
                        Text("Открыть", color = Color.White)
                    }
                } else {
                    // Время последнего сообщения и количество непрочитанных
                    Text(
                        text = patient.lastMessageTime,
                        color = Color.Gray,
                        fontSize = 12.sp
                    )

                    Spacer(modifier = Modifier.height(4.dp))

                    if (patient.unreadCount > 0) {
                        Box(
                            modifier = Modifier
                                .size(24.dp)
                                .background(Color(0xFF2196F3), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = patient.unreadCount.toString(),
                                color = Color.White,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
            }
        }
    }
    Divider(color = Color.LightGray.copy(alpha = 0.5f))
}