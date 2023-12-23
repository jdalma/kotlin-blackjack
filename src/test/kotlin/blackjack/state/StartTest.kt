package blackjack.state

import io.kotest.matchers.types.shouldBeTypeOf
import org.junit.jupiter.api.Test

class StartTest {

    @Test
    fun start() {
        val state = Start()
        val actual = state.draw(CLOVER_TWO)

        actual.shouldBeTypeOf<Start>()
    }

    @Test
    fun hit() {
        val state = Start()
        val actual = state.draw(CLOVER_TWO).draw(CLOVER_FOUR)

        actual.shouldBeTypeOf<Hit>()
    }

    @Test
    fun blackjack() {
        val state = Start(CLOVER_TEN)
        val actual = state.draw(CLOVER_ACE)

        actual.shouldBeTypeOf<Blackjack>()
    }

    @Test
    fun double_ace() {
        val state = Start(CLOVER_ACE)
        val actual = state.draw(CLOVER_ACE)

        actual.shouldBeTypeOf<Hit>()
    }
}
