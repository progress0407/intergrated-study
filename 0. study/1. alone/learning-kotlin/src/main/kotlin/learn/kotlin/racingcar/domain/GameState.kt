package learn.kotlin.racingcar.domain

enum class GameState {

    INPUT {
        override fun nextState() = RUNNING
    },

    RUNNING {
        override fun nextState() = END
    },

    END {
        override fun nextState() = END
    };

    abstract fun nextState(): GameState
}