def traverse(head):
    if head != None:
        traverse(head.next)
        print(head.data)

def traverse2(head):
    if head != None:
        print(head.data)
        traverse2(head.next)

class Node:
    def __init__(self, data):
        self.__data = data
        self.__next = None
    def linkTo(self, node):
        self.__next = node
    @property
    def next(self):
        return self.__next
    @property
    def data(self):
        return self.__data

one = Node(1)
two = Node(2)
three = Node(3)
four = Node(4)

one.linkTo(two)
two.linkTo(three)
three.linkTo(four)

traverse(one)
traverse2(one)