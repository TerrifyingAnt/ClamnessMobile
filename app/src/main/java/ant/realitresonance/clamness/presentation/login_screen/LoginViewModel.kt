package ant.realitresonance.clamness.presentation.login_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ant.realitresonance.clamness.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    // Здесь будут другие зависимости, например:
    // private val loginUseCase: LoginUseCase,
    // private val validateEmailUseCase: ValidateEmailUseCase,
    // private val validatePasswordUseCase: ValidatePasswordUseCase
) : ViewModel() {

    private val _loginState = mutableStateOf(LoginState())
    val loginState: State<LoginState> = _loginState

    /** Обновление состояния UI */
    private fun updateLoginState(update: LoginState.() -> LoginState) {
        _loginState.value = _loginState.value.update()
    }

    fun onEmailChanged(email: String) {
        _loginState.value.email.value = email
        _loginState.value.emailError.value = ""
        validateEmail()
    }

    fun onPasswordChanged(password: String) {
        _loginState.value.password.value = password
        _loginState.value.passwordError.value = ""
        validatePassword()
    }

    fun onPasswordVisibilityChanged() {
        _loginState.value.isPasswordVisible.value = !_loginState.value.isPasswordVisible.value
    }

    fun login() =
        viewModelScope.launch() {
            try {
                // Проверяем валидность ввода
                val emailValid = validateEmail()
                val passwordValid = validatePassword()

                if (!emailValid || !passwordValid) {
                    updateLoginState {
                        copy(loginResult = Resource.error("Пожалуйста, исправьте ошибки в форме"))
                    }
                    return@launch
                }

                updateLoginState {
                    copy(loginResult = Resource.loading())
                }

                // Здесь будет вызов use case для аутентификации
                // val result = loginUseCase(loginState.value.email.value, loginState.value.password.value)

                // Для демонстрации просто имитируем успешный вход через 1 секунду
                kotlinx.coroutines.delay(1000)

                updateLoginState {
                    copy(loginResult = Resource.success("Вход выполнен успешно"))
                }

            } catch (e: Exception) {
                updateLoginState {
                    copy(loginResult = Resource.error(e.message ?: "Произошла ошибка при входе"))
                }
            }
        }

    fun dismissError() {
        updateLoginState {
            copy(loginResult = Resource.loading(null))
        }
    }

    private fun validateEmail(): Boolean {
        // Простая проверка для демонстрации
        val email = _loginState.value.email.value
        val isValid = email.isNotBlank() &&
                email.contains("@") &&
                email.contains(".")

        _loginState.value.isEmailValid.value = isValid

        if (!isValid) {
            _loginState.value.emailError.value = "Введите корректный email"
        }

        return isValid
    }

    private fun validatePassword(): Boolean {
        // Простая проверка для демонстрации
        val password = _loginState.value.password.value
        val isValid = password.length >= 6

        _loginState.value.isPasswordValid.value = isValid

        if (!isValid) {
            _loginState.value.passwordError.value = "Пароль должен содержать минимум 6 символов"
        }

        return isValid
    }
}