package com.example.homework.FriendRecycler

class FriendsRepository {

    companion object {

        fun add(item: Friend, position: Int) {
            if (position > dataSource.count())
                dataSource.add(dataSource.count(), item)
            else
                dataSource.add(position, item)
        }

        fun getDataSource(): List<Friend> = dataSource.toList()

        fun removeItem(position: Int) = dataSource.removeAt(position)

        private val dataSource: MutableList<Friend> = mutableListOf(
            Friend("i", "Best Friend"),
            Friend("You", "Best friend"),
            Friend("Leonardo", "Boyfriend"),
            Friend("Edward", "Friend"),
            Friend("Justin", "Friend"),
            Friend("Edward", "Friend"),
            Friend("Justin", "Friend")
        )
    }
}
