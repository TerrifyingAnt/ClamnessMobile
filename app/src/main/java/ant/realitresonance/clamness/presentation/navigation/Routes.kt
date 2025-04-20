package ant.realitresonance.clamness.presentation.navigation

sealed class Routes(val route: String) {
    // Аутентификация
    object Login : Routes("login_screen")
    object Register : Routes("register_screen")



    // Чат врача
    object DoctorChat : Routes("doctor_chat_screen")
    object PatientChatDetail : Routes("patient_chat_detail_screen/{patient_id}") {
        fun createRoute(patientId: Int) = "patient_chat_detail_screen/$patientId"
    }
    object Profile : Routes("profile")
    object Description: Routes("description/{id}")
}