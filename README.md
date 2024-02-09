# Simple-Java-Terminal-Chat-Application

# Description:
The Simple Java Terminal Chat Application is a basic implementation of a chat system where users can communicate with each other via the terminal using a client-server architecture. The application consists of two main components: a server and a client.

# Features:

**1.Server Component:**
Listens for incoming connections from clients.
Sends and receives messages to and from connected clients.
Supports bidirectional communication between the server and clients.


**2.Client Component:**
Connects to the server using the server's IP address and port number.
Sends and receives messages to and from the server.
Supports bidirectional communication between the client and server.


# Functionality:
Users can start the server, which listens for incoming connections from clients.
Users can start one or more clients and connect them to the server.
Once connected, clients and the server can exchange messages in real-time.
Bidirectional communication allows both the server and clients to send and receive messages.


# Usage:
Compile and run the Server class to start the server.
Compile and run the Client class to start one or more clients.
Clients can send messages to the server, which relays them to other connected clients.
Clients can also receive messages from the server and other connected clients.
Users can type 'exit' to quit the chat and close the connections.
