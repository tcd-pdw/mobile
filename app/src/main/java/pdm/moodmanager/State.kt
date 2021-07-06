package com.example.moodmanager

abstract class State {
    open var score = 0

    abstract fun ToPositive():State
    abstract fun ToRegular():State
    abstract fun ToNegative():State
}