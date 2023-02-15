# print("Enter 2 numbers:")
a = int(input("Enter number 1: "))
b = int(input("Enter number 2: "))
c=0

operation = input("Select operation: ")
match operation:
    case '+':
        c = a + b
        print("Result of adding = ", c)
    case '-':
        c = a - b
        print("Result of substraction = ", c)

print("Programm ended. Thank you for using.")
