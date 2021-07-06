package com.example.moodmanager

class Regular(override var score:Int): State() {

    override fun ToPositive(): State {
        score++
        return Positive(score)
    }

    override fun ToRegular(): State {
        return Regular(score)
    }

    override fun ToNegative(): State {
        score--
        return Negative(score)
    }
}