package uz.oybek0005.zoomraddemo.domain.usecase.impl

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.onEach
import uz.oybek0005.zoomraddemo.data.remote.request.SignInRequest
import uz.oybek0005.zoomraddemo.domain.repository.auth.AuthRepository
import uz.oybek0005.zoomraddemo.domain.usecase.ResendCodeUseCase
import uz.oybek0005.zoomraddemo.domain.usecase.SignInUseCase
import javax.inject.Inject


/**
 * Created by Oybek on 06/12/2024.
 */

class SignInUseCaseImpl @Inject constructor(
    private val authRepository: AuthRepository,
):SignInUseCase {

    override suspend fun invoke(signInRequest: SignInRequest): Result<Unit>? {
        return authRepository.signIn(signInRequest).firstOrNull()
    }


}