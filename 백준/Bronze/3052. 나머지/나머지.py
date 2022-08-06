nums = []
remain = set()
for _ in range(10):
    nums.append(int(input()))
for i in range(10):
    remain.add(nums[i]%42)
print(len(remain))