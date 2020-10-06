class Player(val id: Int, val name: String, val hp: Int) {
    companion object {

        val hp = 100

        var id = 0
            set (value) {
                field = id ++
            }

        fun create(name: String): Player{
            return Player(id, name, hp)
        }
    }
}