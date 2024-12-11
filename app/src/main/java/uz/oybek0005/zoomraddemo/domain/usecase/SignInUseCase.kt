package uz.oybek0005.zoomraddemo.domain.usecase

import uz.oybek0005.zoomraddemo.data.remote.request.SignInRequest


/**
 * Created by Oybek on 06/12/2024.
 */

interface SignInUseCase {
    suspend operator fun invoke(signInRequest: SignInRequest):Result<Unit>?
}