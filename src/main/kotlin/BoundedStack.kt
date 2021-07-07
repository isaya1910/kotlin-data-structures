class BoundedStack<T>(val maxStackSize: Int = 32) {

    private val stack: MutableList<T> = mutableListOf()
    private var peekStatus: Int = PEEK_NIL
    private var popStatus: Int = POP_NIL
    private var pushStatus: Int = PUSH_NIL
    fun push(value: T) {
        pushStatus = if (size() < maxStackSize) {
            stack.add(value)
            PUSH_OK
        } else {
            PUSH_ERR
        }
    }

    fun pop() {
        popStatus = if (size() > 0) {
            stack.removeLast()
            POP_OK
        } else {
            POP_ERR
        }
    }

    fun peek(): T? {
        peekStatus = if (size() > 0) {
            PEEK_OK
        } else {
            PEEK_ERR
        }
        return stack.lastOrNull()
    }

    fun size(): Int {
        return stack.size
    }


    fun clear() {
        stack.clear()
        peekStatus = PEEK_NIL
        popStatus = POP_NIL
    }

    fun getPeekStatus() = peekStatus
    fun getPopStatus() = popStatus
    fun getPushStatus() = pushStatus

    companion object {
        const val POP_NIL = 0
        const val POP_OK = 1
        const val POP_ERR = 2
        const val PEEK_NIL = 0
        const val PEEK_OK = 1
        const val PEEK_ERR = 2
        const val PUSH_NIL = 0
        const val PUSH_OK = 1
        const val PUSH_ERR = 2
    }
}