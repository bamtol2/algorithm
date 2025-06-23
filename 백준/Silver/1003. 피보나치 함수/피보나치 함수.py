t = int(input()) # 테스트 케이스
for _ in range(t):
    n = int(input())

    # 0과 1의 호출 횟수(N은 40보다 작거나 같은 자연수 또는 0)
    zero = [0] * (41)
    one = [0] * (41)
    
    zero[0], one[0] = 1, 0 # f(0)
    zero[1], one[1] = 0, 1 # f(1)

    for i in range(2, n+1):
        zero[i] = zero[i-1] + zero[i-2]
        one[i] = one[i-1] + one[i-2]

    print(zero[n], one[n])