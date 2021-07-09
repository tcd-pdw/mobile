package com.example.moodmanager.states

class Positive(override var score:Int): State() {

    override fun ToPositive(): State {
        score++
        return Positive(score)
    }

    override fun ToRegular(): State {
        score--
        return Regular(score)
    }

    override fun ToNegative(): State {
        score-=2
        return Negative(score)
    }
}