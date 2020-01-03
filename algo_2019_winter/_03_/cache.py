def caching(cacheSize, cities):
    __t = 0
    __cache = []
    for city in cities:
        if cacheSize == 0:
            __t = __t + 5
            continue
        city = city.lower()
        if city in __cache:
            __t = __t + 1
            __cache.remove(city)
            __cache.append(city)
        if city not in __cache:
            __t = __t + 5
            if len(__cache) == cacheSize:
                __cache.remove(__cache[0])
            __cache.append(city)
    return __t


import unittest
class TestCache(unittest.TestCase):
    def testExecTime(self):
        cacheSizes = [3, 3, 2, 5, 2, 0]
        citiesArr = [ 
            ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"],
            ["Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"],
            ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"],
            ["Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"],
            ["Jeju", "Pangyo", "NewYork", "newyork"],
            ["Jeju", "Pangyo", "Seoul", "NewYork", "LA"] 
        ]
        execTime = [50, 21, 60, 52, 16, 25]
        for i in range(0, 6):
            self.assertEqual(execTime[i], caching(cacheSizes[i], citiesArr[i]))

if __name__ == '__main__':
    unittest.main()


