# JEDA - Java Event Driven Architecture

[![Hippocratic License HL3-FULL](https://img.shields.io/static/v1?label=Hippocratic%20License&message=HL3-FULL&labelColor=5e2751&color=bc8c3d)](https://firstdonoharm.dev/version/3/0/full.html)

JEDA is a simple proof-of-concept event-driven architecture. It aims to support
the following features:

- Observers
- Event queues
- Event priority
- Thread safe

This also includes a deterministic finite state machine implementation.

## Design

> See _[Wikipedia - Event-driven architecture](https://en.wikipedia.org/wiki/Event-driven_architecture)_

Ideally the usage of this architecture leads to a highly-decoupled system that can also widely scale.

**Events** are pushed on a significant state change.

**Observers** are notified when an event is pushed.

**Event queues** are used to store events as well as prioritize them.

**Event priority** is used to prioritize events. This can also lead to behaviors such as observers modifying events before other observers are notified.
