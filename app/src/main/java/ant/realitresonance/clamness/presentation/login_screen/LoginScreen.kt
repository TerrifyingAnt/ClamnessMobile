package ant.realitresonance.clamness.presentation.login_screen


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import ant.realitresonance.clamness.presentation.login_screen.components.EmailTextField
import ant.realitresonance.clamness.presentation.login_screen.components.PasswordTextField
import ant.realitresonance.clamness.utils.Resource

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    onNavigateToRegister: () -> Unit,
    onNavigateToForgotPassword: () -> Unit,
    onNavigateToMain: () -> Unit
) {
    val loginState by viewModel.loginState

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Верхняя часть с зелёным фоном и логотипом
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
                    .background(Color(0xFF9CB26E))
                    .clip(RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp)),
                contentAlignment = Alignment.Center
            ) {
                // Здесь можно добавить логотип
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .background(Color.White, shape = RoundedCornerShape(50)),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(16.dp)
                                .background(Color.White, shape = RoundedCornerShape(50))
                                .padding(2.dp)
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Box(
                            modifier = Modifier
                                .size(16.dp)
                                .background(Color.White, shape = RoundedCornerShape(50))
                                .padding(2.dp)
                        )
                    }
                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(16.dp)
                                .background(Color.White, shape = RoundedCornerShape(50))
                                .padding(2.dp)
                        )
                        Spacer(modifier = Modifier.width(2.dp))
                        Box(
                            modifier = Modifier
                                .size(16.dp)
                                .background(Color.White, shape = RoundedCornerShape(50))
                                .padding(2.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Заголовок "Войти"
            Text(
                text = "Войти",
                style = MaterialTheme.typography.headlineMedium,
                color = Color(0xFF5C4033)
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Поле ввода почты
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                Text(
                    text = "Почта",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color(0xFF5C4033)
                )

                Spacer(modifier = Modifier.height(8.dp))

                EmailTextField(
                    value = loginState.email.value,
                    onValueChange = { viewModel.onEmailChanged(it) },
                    placeholder = "Введите почту",
                    isError = loginState.emailError.value.isNotEmpty(),
                    errorMessage = loginState.emailError.value
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Пароль",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color(0xFF5C4033)
                )

                Spacer(modifier = Modifier.height(8.dp))

                PasswordTextField(
                    value = loginState.password.value,
                    onValueChange = { viewModel.onPasswordChanged(it) },
                    placeholder = "Введите пароль",
                    isPasswordVisible = loginState.isPasswordVisible.value,
                    onPasswordVisibilityChange = { viewModel.onPasswordVisibilityChanged() },
                    isError = loginState.passwordError.value.isNotEmpty(),
                    errorMessage = loginState.passwordError.value
                )

                Spacer(modifier = Modifier.height(32.dp))

                // Кнопка "Войти"
                Button(
                    onClick = { viewModel.login() },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF5C4033)
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(56.dp),
                    shape = RoundedCornerShape(28.dp),
                    enabled = loginState.loginResult.status != Resource.Status.LOADING
                ) {
                    if (loginState.loginResult.status == Resource.Status.LOADING) {
                        CircularProgressIndicator(
                            color = Color.White,
                            modifier = Modifier.size(24.dp)
                        )
                    } else {
                        Text(
                            text = "Войти",
                            style = MaterialTheme.typography.bodyLarge,
                            color = Color.White
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Ссылка на регистрацию
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Нет учетной записи? ",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color.Gray
                    )
                    Text(
                        text = "Зарегистрируйте",
                        style = MaterialTheme.typography.bodyMedium,
                        color = Color(0xFF4CAF50),
                        modifier = Modifier.clickable { onNavigateToRegister() }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Ссылка "Забыли пароль"
                Text(
                    text = "Забыли пароль",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray,
                    modifier = Modifier
                        .clickable { onNavigateToForgotPassword() }
                        .align(Alignment.CenterHorizontally)
                )
            }
        }

        // Показываем сообщение об ошибке, если есть
        if (loginState.loginResult.status == Resource.Status.ERROR) {
            AlertDialog(
                onDismissRequest = { /*viewModel.dismissError()*/ },
                title = { Text(text = "Ошибка") },
                text = { Text(text = loginState.loginResult.message ?: "") },
                confirmButton = {
                    Button(
                        onClick = { /*viewModel.dismissError()*/ }
                    ) {
                        Text(text = "ОК")
                    }
                }
            )
        }
    }

    // Если вход успешен, переходим на главный экран
    LaunchedEffect(loginState.loginResult.status) {
        if (loginState.loginResult.status == Resource.Status.SUCCESS) {
            onNavigateToMain()
        }
    }
}

