# Parking Lot System

**Language**: Java  
**Topic**: Low-Level Design (LLD)
**Concepts**: OOP, Concurrency, Design Patterns

---

### 🧠 Project Overview

Design and implementation of a **Parking Lot System** in Java following key **Object-Oriented Design** principles.
It handles **multiple vehicle types and parking spot types**, supports **thread-safe operations**, and demonstrates **extensibility** using design patterns.

---

### ⚙️ Features

- Supports multiple vehicle types: `Car`, `Truck`, `Van`, `Motorcycle`
- Multiple parking spot types: `Compact`, `Large`, `Handicapped`, `Motorcycle`
- Singleton `ParkingLot` class managing multiple floors and parking spots
- Entrance and Exit panels for ticket issuance and spot vacating
- Pricing strategy implemented via **Strategy Design Pattern** (hourly pricing)
- Thread-safe spot assignment using synchronized methods and concurrent collections
- Custom exceptions for handling full parking lot and unavailable slots
- Demonstrates parking, exiting, and full-lot handling scenarios
- Dynamic display of available parking slots by type

---

### 🧪 Demo Usage

The `Application` main method demonstrates:

- Creating a parking lot with multiple floors and spots
- Vehicle entry with ticket generation and spot assignment
- Vehicle exit with fee calculation and spot vacating
- Handling attempts to park when the lot is full
- Display
