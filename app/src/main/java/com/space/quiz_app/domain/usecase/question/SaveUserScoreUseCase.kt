package com.space.quiz_app.domain.usecase.question

import com.example.corecommon.base.use_case.BaseUseCase
import com.example.corecommon.domain.model.subject.QuizSubjectDomainModel
import com.example.corecommon.domain.repository.QuizUserSubjectsRepository
import com.example.quiz_impl.domain.usecase.question.SaveUserScore

class SaveUserScoreUseCase(
    private val userSubjectsRepository: QuizUserSubjectsRepository,
) : BaseUseCase<SaveUserScore, Unit>() {

    override suspend fun invoke(params: SaveUserScore?) {
        userSubjectsRepository.saveUserScore(params!!.username, params.score, params.subject)
    }
}

data class SaveUserScore(val username: String, val subject: QuizSubjectDomainModel, val score: Int)