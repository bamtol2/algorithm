def solution(num_list):
    odd = ''.join(str(x) for x in num_list if x % 2)
    even = ''.join(str(x) for x in num_list if x % 2 == 0)
    return int(odd) + int(even)