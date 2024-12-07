package uz.oybek0005.zoomraddemo.domain.usecase


/**
 * Created by Oybek on 06/12/2024.
 */

interface ResendCodeUseCase {
    suspend operator fun invoke():Result<Unit>?
}