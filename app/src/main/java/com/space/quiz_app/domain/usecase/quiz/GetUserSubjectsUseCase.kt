package com.space.quiz_app.domain.usecase.quiz

import com.space.quiz_app.domain.model.user.QuizUserSubjectsDomainModel
import com.space.quiz_app.domain.repository.QuizUserSubjectsRepository
import com.space.quiz_app.domain.usecase.base.BaseUseCase
import com.space.quiz_app.domain.usecase.user.CurrentUseCase

class GetUserSubjectsUseCase(
    private val userSubjectsRepository: QuizUserSubjectsRepository,
    private val currentUser: CurrentUseCase
) : BaseUseCase<Unit, List<QuizUserSubjectsDomainModel>>() {

    override suspend fun invoke(params: Unit?): List<QuizUserSubjectsDomainModel> {
        return userSubjectsRepository.getUserSubjects(currentUser()!!.username)
    }

}