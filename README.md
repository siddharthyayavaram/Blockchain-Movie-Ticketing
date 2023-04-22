# Movie Ticket Booking System using Blockchain

This is a Java-based implementation of a movie ticket booking system using blockchain technology. The system consists of several classes that work together to enable users to book movie tickets securely and transparently.

## Need for this project
1. Security: Blockchain provides a high level of security for customers' personal and financial information.
2. Transparency: Using blockchain could increase transparency in the ticket booking process.
3. Efficiency: Blockchain can help to streamline transactions, making the ticket booking process faster and more convenient for customers.

## Classes
The following are the classes used in this project:

- User: represents a user of the system, who is part of the blockchain, with a username and password for his wallet.
    - We also give initial balance of the user.
    - Every transaction made is added to the arrayList(blockchain) for the corresponding user.
    - Methods:
        - makeTransaction() // only completes and adds to the transaction list if transaction is verified
        - showTransaction() // note showTransaction performs the same task as ViewUser()
        - getLastTransaction()
##
- Wallet: represents a user's digital wallet, which stores their balance and password.
    - Updates wallet after every valid transaction.
    - Methods:
        - updateBalance()
        - getBalance()
##
- Transaction: represents a transaction of a user, buying ticket for a show.
    - Methods:
        - getUserId()
        - getNumTickets()
##
- Shows: represents which shows are available at what time.
    - also tells about price of movie show and number of seats available.
    - gives a unique ID to a show.
    - updates required attributes.
    - all getters abd setters methods available.
##
- TransactionVerifier: represents the class which performs the ZKP to verify transaction.
    - uses ZKP as specified in the document.
##
- Block: represents a block in the blockchain, containing a list of transactions and a reference to the previous block in the chain.
    - stores hash, previousHash , timeStamp and a transaction object to store the transaction.
    - Methods:
        - createBlock() // done through Block constructor and added to the chain using addBlock() method of blockchain class
        - mineBlock()
        - calculateBlockHash()
        - all required getters and setters
##
- Blockchain: represents the blockchain itself, maintaining a list of blocks and providing methods for adding new blocks and verifying the integrity of the chain.
    - also stores difficulty of mining block.
    - methods:
        - isBlockchainValid()
        - addBlock()
        - showChain()

## Usage
To use the movie ticket booking system, follow these steps:

1. Create a new User object for each user of the system, specifying a username, password and initial balance.
2. To book a movie ticket, create a new Transaction object of the user's wallet, specifying the number of tickets for a show(amount is automatically checked against the wallet).
3. Add the Transaction to a new Block object and add the Block to the Blockchain. Although block is only added after the ZKP is verified.
4. Repeat steps 1-3 for each movie ticket booking.

## Installation
To install and run the movie ticket booking system, follow these steps:

1. Clone this repository to your local machine.
2. Open the project in your preferred Java IDE.
3. Run the Main class to start the system.

## Credits
This project was created by
1. Aditya Kumar Sharma
2. Siddharth Yayavaram
3. Arnav Yayavaram
4. Nishchay Deep
5. Rishith Damani
### as a part of the course BITS F463: Cryptography.
