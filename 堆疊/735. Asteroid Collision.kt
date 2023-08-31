

這段程式碼的概念是模擬行星碰撞的過程，並找出最後剩下的行星組合。讓我們來解釋一下程式碼的運作：
首先，建立一個空的可變列表 res，用來保存最後剩下的行星。
接下來，對於每顆行星 asteroid，分為以下兩種情況：

a. 若 asteroid 為正數 (正向移動)，則直接加入到結果列表 res 中。
b. 若 asteroid 為負數 (負向移動)，則需要處理碰撞情況：
檢查 res 是否為空，若為空，直接將負向行星加入 res。
若 res 不為空，則進行碰撞檢查，不斷比較負向行星的絕對值是否大於 res 最後一顆行星的絕對值，直到找到沒有碰撞的位置。
若找到碰撞位置，根據碰撞情況進行不同處理：
若最後一顆行星為正數，則負向行星能破壞這顆正數行星，所以將最後一顆行星從 res 中移除。
若最後一顆行星為負數，則兩顆行星同為負向，互相抵消，所以將負向行星加入 res。
若最後一顆行星的絕對值與負向行星的絕對值相等，表示兩顆行星的質量相同，則將最後一顆行星從 res 中移除。
最後，返回 res 轉換成整數陣列的結果，即為最後剩下的行星組合。
總結來說，這段程式碼利用列表 res 模擬了行星碰撞的過程，根據碰撞情況對行星進行增減，最終得到碰撞後剩下的行星組合。

class Solution {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val res = mutableListOf<Int>()
        
        for (asteroid in asteroids) {
            if (asteroid > 0) {
                res.add(asteroid)
            } else {
                while (res.isNotEmpty() && res.last() > 0 && -asteroid > res.last()) {
                    res.removeAt(res.size - 1)
                }
                if (res.isEmpty() || res.last() < 0) {
                    res.add(asteroid)
                } else if (-asteroid == res.last()) {
                    res.removeAt(res.size - 1)
                }
            }
        }
        return res.toIntArray()
    }
}
