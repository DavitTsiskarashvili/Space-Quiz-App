package com.space.quiz_app.common

interface Mapper<in ModelA, out ModelB> {
    operator fun invoke(model: ModelA): ModelB
}