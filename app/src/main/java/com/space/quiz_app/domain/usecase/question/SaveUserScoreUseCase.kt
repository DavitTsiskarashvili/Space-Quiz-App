package com.space.quiz_app.domain.usecase.question

import com.space.quiz_app.domain.model.subject.QuizSubjectDomainModel
import com.space.quiz_app.domain.repository.QuizUserSubjectsRepository
import com.space.quiz_app.domain.usecase.base.BaseUseCase

class SaveUserScoreUseCase(
    private val userSubjectsRepository: QuizUserSubjectsRepository,
) : BaseUseCase<SaveUserScore, Unit>() {

    override suspend fun invoke(params: SaveUserScore?) {
        userSubjectsRepository.saveUserScore(params!!.username, params.score, params.subject)
    }
}

data class SaveUserScore(val username: String, val subject: QuizSubjectDomainModel, val score: Int)