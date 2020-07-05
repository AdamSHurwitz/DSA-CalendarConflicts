// Todo: Run logic in test class.
data class Event(
        val start: Int,
        val end: Int,
        val id: String
)

fun findConflicts(events: List<Event>): ArrayList<ArrayList<Event>> {
    val allConflicts = arrayListOf<ArrayList<Event>>()
    var conflict = arrayListOf<Event>()
    var tempEndIndex = 0
    var isConflict = false
    for (i in 0..events.size - 1) {
        val nextIndex = i + 1
        val endIndex = if (isConflict) tempEndIndex else i
        if (nextIndex <= events.size - 1 && events[endIndex].end > events[nextIndex].start) {
            conflict.add(events[nextIndex])
            if (isConflict == false)
                tempEndIndex = i
            isConflict = true
        } else {
            if (isConflict == true) {
                allConflicts.add(conflict)
                conflict = arrayListOf()
            }
            isConflict = false
        }
    }
    return allConflicts
}