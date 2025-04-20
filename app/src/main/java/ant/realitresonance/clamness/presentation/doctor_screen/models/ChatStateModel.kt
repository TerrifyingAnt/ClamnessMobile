package ant.realitresonance.clamness.presentation.doctor_screen.models

import ant.realitresonance.clamness.utils.Resource

data class ChatState(
    val patients: List<Patient> = emptyList(),
    val patientsResult: Resource<List<Patient>> = Resource.loading()
)
