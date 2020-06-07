package leetcode.linklist

import java.util.*
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.LinkedBlockingDeque

/**
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。

获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。
写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。
当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lru-cache
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

data class Node<T, V>(var key: T, var value: V)
class LRUCache<T, V>(val capacity: Int) {
    val hashMap = ConcurrentHashMap<T, Node<T, V>>()
    val linkedList = LinkedBlockingDeque<Node<T, V>>()
    fun get(key: T): V? {
        val node = hashMap[key] ?: return null
        // 移动到头部
        linkedList.remove(node)
        linkedList.putFirst(node)
        return node.value
    }

    fun put(key: T, value: V) {
        var node = hashMap[key]
        if (node == null) {
            node = Node(key, value)
            hashMap[key] = node
            val size = linkedList.size
            if (size + 1 > capacity) {
                val lastNode = linkedList.pollLast()
                hashMap.remove(lastNode.key)
            }
            linkedList.putFirst(node)
        } else {
            node.value = value
            node.key = key
            hashMap[key] = node
            linkedList.remove(node)
            linkedList.putFirst(node)
        }
    }
}

fun main() {
//    val lruCache = LRUCache(2)
//    lruCache.put(1, 1)
//    lruCache.put(2, 2)
//    lruCache.get(1)
//    lruCache.put(3, 3)
//    lruCache.get(2)
//    lruCache.put(4, 4)
//    lruCache.get(1)
//    lruCache.get(3)
    /**
     * 2
     */
//    val lruCache = LRUCache(1)
//    lruCache.put(2, 1)
//    lruCache.get(2)
//    lruCache.put(3, 2)
//    lruCache.get(2)
//    lruCache.get(3)

//    val lruCache = LRUCache(2)

}
