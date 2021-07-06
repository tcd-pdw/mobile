package com.example.moodmanager

class Negative(override var score:Int): State() {

    override fun ToPositive(): State {
        score+=2
        return Positive(score)
    }

    override fun ToRegular(): State {
        score++
        return Regular(score)
    }

    override fun ToNegative(): State {
        score--
        return Negative(score)
    }
}