package ant.realitresonance.clamness.presentation.doctor_screen.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ant.realitresonance.clamness.presentation.doctor_screen.models.Patient

@Composable
fun PatientList(
    patients: List<Patient>,
    onPatientClick: (Int) -> Unit
) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 8.dp)
    ) {
        items(patients) { patient ->
            PatientItem(
                patient = patient,
                onClick = { onPatientClick(patient.id) }
            )
        }
    }
}