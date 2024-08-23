import sys
input = sys.stdin.readline

N = int(input())
Anums = list(map(int,input().split()))
M = int(input())
Mnums = list(map(int,input().split()))

Anums.sort()

def search(st,en,target):
    if st == en:
        if Anums[st] == target:
            print(1)
        else:
            print(0)
        return

    mid = (st + en) // 2
    if Anums[mid] < target:
        search(mid+1,en,target)
    else:
        search(st,mid,target)


for target in Mnums:
    search(0,N-1,target)