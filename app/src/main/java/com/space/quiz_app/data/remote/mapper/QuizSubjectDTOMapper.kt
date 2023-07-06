package com.space.quiz_app.data.remote.mapper

import com.space.quiz_app.common.mapper.Mapper
import com.space.quiz_app.data.local.entity.QuizSubjectEntity
import com.space.quiz_app.data.remote.model.QuizSubjectDTO

class QuizSubjectDTOMapper : Mapper<QuizSubjectDTO, QuizSubjectEntity> {
    override fun invoke(model: QuizSubjectDTO): QuizSubjectEntity =
        with(model) {
            QuizSubjectEntity(
                id = id,
                quizTitle = quizTitle,
                quizDescription = quizDescription,
                quizIcon = quizIcon,
                questionsCount = questionsCount,
            )
        }
}