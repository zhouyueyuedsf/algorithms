package company.bcz.one.twi;

/**
 * import sys

 n = int(input())
 m = []
 numbers = []
 for i in range(n):
 line = [int(i) for i in input().split()]
 m.append(line[0])
 numbers.append(line[1:])

 ans = []
 total_number = sum(m)

 cur_index = [0] * n
 to_insert = [n[0] for n in numbers]
 while len(ans) < total_number:
 min_index = to_insert.index(min(to_insert))
 cur_index[min_index] += 1
 ans.append(min(to_insert))
 if cur_index[min_index] == m[min_index]:
 to_insert[min_index] = sys.maxsize
 else:
 to_insert[min_index] = numbers[min_index][cur_index[min_index]]

 print(' '.join(map(str, ans)), end='')
 */
public class Main4 {
}
