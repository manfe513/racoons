# print("Enter 2 numbers:")
a = int(input("Enter number 1: "))
b = int(input("Enter number 2: "))
c=0
#//////
operation = input("Select operation: ")
match operation:
    case '+':
        c = a + b
    case '-':
        c = a - b
    case '*':
        c = a * b
    case '/':
        c = a / b

print("result = ", c)
