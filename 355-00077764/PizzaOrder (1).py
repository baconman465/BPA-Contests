import random
import math

class Pizzas:   
   
   def __init__(self, code, name, price, freezerAmount):
      self.code = code
      self.name = name
      self.price = int(price)
      self.freezerAmount = int(freezerAmount)
   
   def __str__(self):
      menuCodeStr = "Menu Code: {}"
      menuNameStr = "Menu Name: {}"
      menuPriceStr = "Menu Price: ${:.2f}"
      menuCountStr = "Total Pizza Count: {}"
      menuTotalStr = "Total Inventory Cost: $ {:.2f}"
      
      print(menuCodeStr.format(self.code))
      print(menuNameStr.format(self.name))
      print(menuPriceStr.format(self.price))
      print(menuCountStr.format(self.freezerAmount))
      print(menuTotalStr.format((self.price * self.freezerAmount)))
            
   def getValue(self): 
      pass
   
   def toString(self):
      pass

########################
########################
#DRIVER SECTION
      #Enter your code below

print("How many simulated frozen pizza items do you want to create You must enter between 1 and 10.")

pizzaAmount = 0

while(True):
   pizzaAmount = input()
   
   if(not pizzaAmount.isnumeric()):
      print("WARNING! You cannot enter in letters. Try again.")
      # continue
   elif(int(pizzaAmount) < 1 or int(pizzaAmount) > 10):
      print("WARNING! Your entered too low or too high for the quantity. Try again please.")
      # continue
   else:
      break

print("You entered: " + pizzaAmount)
pizzaAmount = int(pizzaAmount) #converts pizzaAmount to int to enable numeric operations to be done on it

print("You will now create the menu item code for the inventory management system, name of the menu item and how much inventory for the pizza to keep in the freezer. The price will be randomly generated.\n\n")

pizzaList = []
lcv = 1
while(lcv <= pizzaAmount):
   print("Please enter a three letter/number code for pizza number " + str(lcv) + ":")
   
   while(True):
      pizzaCode = input()
      if(not len(pizzaCode) == 3):
         print("\nYou entered an incorrect value:")
      else:
         break

   print("You entered: " + pizzaCode)
   print("Please enter the pizza name:")
   pizzaName = input()
   
   print("Please enter total inventory count of this " + pizzaName + " to keep in the freezer:")
   
   while(True):
      pizzaFreezerCount = input()
      if(not pizzaFreezerCount.isnumeric()):
         print("WARNING! You cannot enter in letters. Try again.")
      else:
         break
   
   pizzaList.append(Pizzas(pizzaCode, pizzaName, random.randrange(10,20), pizzaFreezerCount))
   lcv += 1

print("Listen below is your current pizza inventory:")
for x in pizzaList:
   print(x)
   print("\n")