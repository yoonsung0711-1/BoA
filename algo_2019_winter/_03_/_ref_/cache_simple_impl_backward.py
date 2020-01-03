class SimpleCache:
    def __init__(self, csize):
        self.__csize = csize
        self.__deque = []  # 메모리주소를 관리하는 자료구조
        self.__cache = {}  # 캐시메모리 역할을 하는 map

    @property
    def getSize(self):
        return self.__csize

    def refer(self, num):
        # cache miss가 발생한 경우
        if self.__cache.get(num) is None:
            # cache가 가득 찬 경우 제일 오래된 캐시 삭제
            if len(self.__deque) == self.__csize:
                last = self.__deque.pop()
                del self.__cache[last]
        # cache hit가 발생한 경우
        elif self.__cache.get(num) is not None:
            self.__deque.remove(num)
        self.__deque.insert(0, num)
        self.__cache[num] = self.__deque[0]

    def display(self):
        for d in self.__deque:
            print(d)

c = SimpleCache(5)
c.refer(1); c.display()
c.refer(2); c.display()
c.refer(3); c.display()
c.refer(1); c.display()
c.refer(4); c.display()
c.refer(5); c.display()
c.refer(6); c.display()
