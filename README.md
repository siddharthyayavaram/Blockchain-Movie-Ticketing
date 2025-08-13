# Blockchain Movie Ticketing System

This is a Java-based implementation of a decentralized movie ticket booking system using blockchain technology. The system enables users to book movie tickets securely and transparently without the need for a central authority.

## Features

*   **Decentralized:** The system uses a peer-to-peer network to store and verify transactions, eliminating the need for a central server.
*   **Secure:** All transactions are secured using cryptographic hashing and digital signatures, making them tamper-proof.
*   **Transparent:** All transactions are recorded on a public ledger, making them transparent to all participants in the network.
*   **Peer-to-Peer:** The system allows users to transact directly with each other without the need for intermediaries.

## Getting Started

### Prerequisites

*   Java Development Kit (JDK) 8 or higher
*   Git

### Installation

1.  Clone this repository to your local machine:

    ```bash
    git clone https://github.com/siddharthyayavaram/Blockchain-Movie-Ticketing.git
    ```

2.  Navigate to the project directory:

    ```bash
    cd Blockchain-Movie-Ticketing
    ```

### Compilation

To compile the Java source files, run the following command from the project root directory:

```bash
javac -d bin src/*.java
```

### Usage

To run the application, execute the following command from the project root directory:

```bash
java -cp bin Main
```

## How It Works

The system is composed of the following components:

*   **User:** Represents a user of the system, who has a digital wallet to store their balance and make transactions.
*   **Wallet:** Represents a user's digital wallet, which stores their balance and is used to sign transactions.
*   **Transaction:** Represents a transaction for booking a movie ticket. Each transaction is digitally signed by the user to ensure its authenticity.
*   **Shows:** Represents the available movies, showtimes, and ticket prices.
*   **TransactionVerifier:** Verifies the authenticity of a transaction using Zero-Knowledge Proofs (ZKP).
*   **Block:** Represents a block in the blockchain, which contains a list of verified transactions.
*   **Blockchain:** Represents the distributed ledger that stores all the blocks in the chain.