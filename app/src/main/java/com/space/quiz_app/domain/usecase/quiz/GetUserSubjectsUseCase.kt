package com.space.quiz_app.domain.usecase.quiz

import com.example.corecommon.base.use_case.BaseUseCase
import com.example.corecommon.domain.model.user.QuizUserSubjectsDomainModel
import com.example.corecommon.domain.repository.QuizUserSubjectsRepository
import com.example.quiz_impl.domain.usecase.user.CurrentUserUseCase

class GetUserSubjectsUseCase(
    private val userSubjectsRepository: QuizUserSubjectsRepository,
    private val currentUser: CurrentUserUseCase
) : BaseUseCase<Unit, List<QuizUserSubjectsDomainModel>>() {

    override suspend fun invoke(params: Unit?): List<QuizUserSubjectsDomainModel> {
        return userSubjectsRepository.getUserSubjects(currentUser()!!.username)
    }

}