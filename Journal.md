# Phase 1

A Queue is appropriate for a message broker because it uses FIFO, meaning the first message added is the first one processed. This keeps messages in the correct order. If a Stack was used instead, it would use LIFO, meaning the newest message would be processed first and older messages could be delayed.

# Phase 2

When a message fails, it is added to the back of the Queue instead of being processed again immediately. This makes the system more fair because other messages get a chance to be processed before the failed message is tried again. The retry count also keeps track of how many times the message has failed.

# Phase 3

A poison message starts in the main Queue and is processed like any other message. Each time it fails, its retry count increases and it is placed back at the end of the Queue. Once it reaches the maximum number of retries, it is removed from the main Queue and moved to the Dead-Letter Queue so it cannot keep blocking the system.
