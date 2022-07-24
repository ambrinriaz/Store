# Store
### Store application where you can order Apples/Oranges and get notifications about the status of the order.

### Usage

Use the "run.sh" script to add items to the order

```bash
./run.sh Apple Orange Apple
```
Running this will give you the Order status (Completed or Failed), Estimated delivery time and Total order price

"InMemoryItemRepository" holds information about stock (total number of Apples or Oranges). 
When this respository instance is passed to Order service you can set the itmes in stock. The default value in stock is 10 Apples and 10 Oranges.

Use "Main.kt" to update the stock information. For example you can update the stock to hold 5 apples and 5 oranges as follows,

```kotlin
val orderService = OrderService(
        InMemoryItemRepository(5, 5),
        InMemoryOfferRepository()
    )
```

The store has two offers - Buy one get one free on Apples and 3 for the price of 2 on Oranges

When you add items to order, these offers are applied. For example adding 3 apples and one orange, your total price would be $1.45

```bash
./run.sh Apple Orange Apple Apple
```
The estimated delivery time is calculated by adding 3 days to the current date. 
This can be changed by updating constant "DEFAULT_DELIVERY_TIME_IN_DAYS" in the "ItemConstants.kt"
