import sys

if __name__ == "__main__":
    n = int(sys.stdin.readline().strip())

    stack = []
    left = ["(","[","{"]
    right = [")","]","}"]
    bi = ["()","{}","[]"]
    for i in range(n):
        gwalhos = sys.stdin.readline().strip()
        balanced = True
        for g in gwalhos:
            if g in left:
                stack.append(g)
            elif g in right:
                if (stack.pop()+g) not in bi:
                    balanced = False
                    print("NO")
                    break

        if balanced:
            print("YES")
