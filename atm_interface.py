''' My ATM Interface Project but in Python '''

import datetime

print("Welcome to Your Bank: Providing For All Your Financial Needs Today and Tomorrow.")

def goodbye():
    print("Thank you for choosing us to serve your financial needs. Please visit us again soon!")
    exit()

def withdraw_check(account, amount, checking, savings):
    if account == "checking":
        
        if amount > checking:
            print("Withdrawal Denied.")
            return False
        else:
            print("Withdrawal Approved!")
            return True

    else:
        
        if amount > savings:
            print("Withdrawal Denied.")
            return False
        else:
            print("Withdrawal Approved!")
            return True

checking = 120
savings = 65
date = datetime.datetime.now()

trys = 0
while trys < 3:
    pin_num = int(input("Enter PIN Number: "))
    
    if pin_num == 6565:
        print("Thank you for verifying!")
        verified = True
        break
    else:
        if trys == 2:
            print("Too many wrong attempts, we will be keeping your card for security reasons.")
            print("Plase contact our account services agents at 1-800-555-1234.")
            goodbye()
        else:
            print("Please try again.")
            trys += 1

trans_num = 0
while verified:

    while True:
        account = input("Which account would you like to select? (Checking or Savings): ").lower()

        if account == "checking":
            print("Checking account selected!")
            break
        elif account == "savings":
            print("Savings account selected!")
            break
        else:
            print("Please enter a valid account type.")

    while True:
        trans_type = input("What type of transaction would you like to make? (Withdraw or Look up): ").lower()

        if trans_type == "withdraw":
            
            while True:
                withdraw = input("How would you like to withdraw? (Check or Cash): ").lower()

                if withdraw == "check":
                    amount = int(input("Please enter a withdrawal amount: "))

                    if withdraw_check(account, amount, checking, savings):

                        if account == "checking":
                            checking -= amount
                        else:
                            savings -= amount

                        break
                    else:
                        goodbye()

                elif withdraw == "cash":
                    
                    while True:
                        fast_cash = input("Would you like to use Fast Cash? (Yes or No): ").lower()

                        if fast_cash == "yes":
                            
                            while True:
                                amount = int(input("Please select Fast Cash option ($20, $40, $80, $100): "))

                                if amount == 20:
                                    print("$20 Fast Cash selected.")

                                    if withdraw_check(account, amount, checking, savings):
                                        if account == "checking":
                                            checking -= amount
                                        else:
                                            savings -= amount
                                    else:
                                        goodbye()
                                    
                                    break
                                elif amount == 40:
                                    print("$40 Fast Cash selected.")

                                    if withdraw_check(account, amount, checking, savings):
                                        if account == "checking":
                                            checking -= amount
                                        else:
                                            savings -= amount
                                    else:
                                        goodbye()
                                        
                                    break
                                elif amount == 80:
                                    print("$80 Fast Cash selected.")

                                    if withdraw_check(account, amount, checking, savings):
                                        if account == "checking":
                                            checking -= amount
                                        else:
                                            savings -= amount
                                    else:
                                        goodbye()
                                        
                                    break
                                elif amount == 100:
                                    print("$100 Fast Cash selected.")

                                    if withdraw_check(account, amount, checking, savings):
                                        if account == "checking":
                                            checking -= amount
                                        else:
                                            savings -= amount
                                    else:
                                        goodbye()
                                        
                                    break
                                else:
                                    print("Please select a valid Fast Cash option.")

                            break
                        elif fast_cash == "no":
                            amount = int(input("Please enter a withdrawal amount: "))

                            if withdraw_check(account, amount, checking, savings):

                                if account == "checking":
                                    checking -= amount
                                else:
                                    savings -= amount

                                break
                            else:
                                goodbye()

                    break      
                else:
                    print("Please select a valid withdraw method.")

            break
        elif trans_type == "look up":
            print("Looking up balance for your account.")
            break
        else:
            print("Please enter a valid transaction type.")

    while True:
        receipt = input("Would you like a receipt? (Yes or No): ").lower()

        if receipt == "yes":
            print("Here is your receipt:")
            print("--------------------------")
            print(f"Transaction Type: {trans_type}")
            
            if trans_type == "look up":
                amount = 0

            print(f"Withdrawal Amount: {amount}")

            if account == "checking":
                print(f"Account Balance: {checking}")
            else:
                print(f"Account Balance: {savings}")

            print(date)
            print("--------------------------")
            break
        elif receipt == "no":
            break

    if trans_type == "withdraw":
        
        if withdraw == "cash":
            print(f"Please take your cash amount of ${amount}")
        else:
            print(f"Please take your check amount of ${amount}")

    else:
        print("Here is the balance for the selected account: ", end="")

        if account == "checking":
            print(checking)
        else:
            print(savings)

    if trans_num == 2:
        goodbye()

    transaction = input("Would you like to make another transaction? (Yes or No): ").lower()

    if transaction == "yes":
        trans_num += 1
    elif transaction == "no":
        goodbye()
