package uz.oybek0005.zoomraddemo.domain.usecase.impl

import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.onEach
import uz.oybek0005.zoomraddemo.domain.repository.auth.AuthRepository
import uz.oybek0005.zoomraddemo.domain.usecase.ResendCodeUseCase
import javax.inject.Inject


/**
 * Created by Oybek on 06/12/2024.
 */

class ResendCodeUseCaseImpl @Inject constructor(
    private val authRepository: AuthRepository,
) : ResendCodeUseCase {

    override suspend fun invoke(): Result<Unit>? {
        return authRepository.registerResendCode().firstOrNull()
    }


}