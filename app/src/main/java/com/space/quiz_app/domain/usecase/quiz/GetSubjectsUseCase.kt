package com.space.quiz_app.domain.usecase.quiz

import com.space.quiz_app.domain.model.subject.QuizSubjectDomainModel
import com.space.quiz_app.domain.repository.QuizSubjectsRepository
import com.space.quiz_app.domain.usecase.base.BaseUseCase

class GetSubjectsUseCase(
    private val quizSubjectsRepository: QuizSubjectsRepository,
) : BaseUseCase<Unit, List<QuizSubjectDomainModel>>() {

    override suspend fun invoke(params: Unit?): List<QuizSubjectDomainModel> {
        return quizSubjectsRepository.getSubjectsFromDatabase()
    }

}