package test

import Event
import findConflicts
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.MethodOrderer
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestMethodOrder

@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TestSolve {
    @Test
    @Order(1)
    fun `First test`() {
        val events = listOf(
                Event(1, 2, "a"),
                Event(3, 9, "b"),
                Event(5, 6, "c"),
                Event(7, 8, "d"),
                Event(9, 10, "e"))
        val conflicts = listOf(
                listOf(Event(3, 9, "b"), Event(5, 6, "c"), Event(7, 8, "d"))
        )
        val actual = findConflicts(events)
        printAssert(actual, conflicts)
        assertThat(actual).isEqualTo(conflicts)
    }

    @Test
    @Order(1)
    fun `Second test`() {
        val events = listOf(
                Event(1, 2, "a"),
                Event(2, 4, "b"),
                Event(3, 5, "c"),
                Event(6, 8, "d"),
                Event(9, 13, "e"),
                Event(12, 15, "f"),
                Event(14, 16, "g"),
                Event(17, 19, "h"),
                Event(20, 21, "i"),
                Event(20, 21, "j"))
        val conflicts = listOf(
                listOf(
                        Event(2, 4, "b"),
                        Event(3, 5, "c")
                ),
                listOf(
                        Event(9, 13, "e"),
                        Event(12, 15, "f"),
                        Event(14, 16, "g")
                ),
                listOf(
                        Event(20, 21, "i"),
                        Event(20, 21, "j")
                )
        )
        val actual = findConflicts(events)
        printAssert(actual, conflicts)
        assertThat(actual).isEqualTo(conflicts)
    }
}