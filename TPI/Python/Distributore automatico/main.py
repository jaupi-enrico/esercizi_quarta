def sumSales(sales):
    total = 0
    for sale in sales:
        total += sale
    return total

def mostSales(sales):
    max_sales_index = 0
    for i in range(1, len(sales)):
        if sales[i] > sales[max_sales_index]:
            max_sales_index = i
    return max_sales_index

def lessThenValue(sales, value):
    count = 0
    for sale in sales:
        if sale < value:
            count += 1
    return count

arr = []

for i in range(5):
    while True:
        value = int(input(f"Enter sales at {i + 9}: "))
        if value >= 0:
            break
        else:
            print("Sales must be non-negative. Please try again.")
    
    arr.append(value)

print("List of sales from 9 AM to 1 PM:", arr)
print("Total sales from 9 AM to 1 PM:", sumSales(arr))
print("Hour with most sales: hour ", mostSales(arr) + 9)
value = int(input("Enter a value to compare sales: "))
print("Number of hours with sales less than", value, ":", lessThenValue(arr, value))