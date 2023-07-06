package com.space.quiz_app.domain.usecase.quiz

import com.example.corecommon.base.use_case.BaseUseCase
import com.example.corecommon.domain.model.subject.QuizSubjectDomainModel
import com.example.corecommon.domain.repository.QuizSubjectsRepository

class GetSubjectsUseCase(
    private val quizSubjectsRepository: QuizSubjectsRepository,
) : BaseUseCase<Unit, List<QuizSubjectDomainModel>>() {

    override suspend fun invoke(params: Unit?): List<QuizSubjectDomainModel> {
        return quizSubjectsRepository.getSubjectsFromDatabase()
    }

}