package ant.realitresonance.clamness.presentation.login_screen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import ant.realitresonance.clamness.utils.Resource


data class LoginState(
    val email: MutableState<String> = mutableStateOf(""),
    val password: MutableState<String> = mutableStateOf(""),
    val isPasswordVisible: MutableState<Boolean> = mutableStateOf(false),
    val emailError: MutableState<String> = mutableStateOf(""),
    val passwordError: MutableState<String> = mutableStateOf(""),
    val isEmailValid: MutableState<Boolean> = mutableStateOf(false),
    val isPasswordValid: MutableState<Boolean> = mutableStateOf(false),
    val loginResult: Resource<String> = Resource.loading()
)