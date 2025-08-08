# 🧮 Smart Discount Allocation Engine

A CLI-based Java project to fairly distribute a fixed discount budget (kitty) among sales agents based on multiple performance metrics. Designed for Red Health’s sales incentives allocation problem.

---

## 📌 Overview

This tool reads a set of sales agents from a JSON file, evaluates them based on configurable performance criteria (weights), and allocates a portion of the discount kitty to each agent accordingly. The output is a JSON file listing each agent’s allocation and the justification behind it.

---

## 🚀 Features

- 📥 Takes input from `input.json`
- ⚖️ Allocates discounts using a weighted score formula
- ⚙️ Supports fully **configurable weight and min/max limits** via `config.json`
- ✅ Validates agent data (ID uniqueness, value ranges)
- 🧾 Outputs result to `output.json` including:
  - Discount amount
  - Justification for the amount
- ❌ Automatically clears or avoids writing `output.json` if validation fails
- 📂 Clean Maven project structure

---

## 🛠️ Setup Instructions

### ✅ 1. Clone or Download
```bash
git clone https://github.com/your-username/discount-allocation.git
cd discount-allocation
# 🧮 Smart Discount Allocation Engine

A CLI-based Java project to fairly distribute a fixed discount budget (kitty) among sales agents based on multiple performance metrics. Designed for Red Health’s sales incentives allocation problem.

---

## 📌 Overview

This tool reads a set of sales agents from a JSON file, evaluates them based on configurable performance criteria (weights), and allocates a portion of the discount kitty to each agent accordingly. The output is a JSON file listing each agent’s allocation and the justification behind it.

---

## 🚀 Features

- 📥 Takes input from `input.json`
- ⚖️ Allocates discounts using a weighted score formula
- ⚙️ Supports fully **configurable weight and min/max limits** via `config.json`
- ✅ Validates agent data (ID uniqueness, value ranges)
- 🧾 Outputs result to `output.json` including:
  - Discount amount
  - Justification for the amount
- ❌ Automatically clears or avoids writing `output.json` if validation fails
- 📂 Clean Maven project structure

---

## 🛠️ Setup Instructions

### ✅ 1. Clone or Download
```bash
git clone https://github.com/your-username/discount-allocation.git
cd discount-allocation
# 🧮 Smart Discount Allocation Engine

A CLI-based Java project to fairly distribute a fixed discount budget (kitty) among sales agents based on multiple performance metrics. Designed for Red Health’s sales incentives allocation problem.

---

## 📌 Overview

This tool reads a set of sales agents from a JSON file, evaluates them based on configurable performance criteria (weights), and allocates a portion of the discount kitty to each agent accordingly. The output is a JSON file listing each agent’s allocation and the justification behind it.

---

## 🚀 Features

- 📥 Takes input from `input.json`
- ⚖️ Allocates discounts using a weighted score formula
- ⚙️ Supports fully **configurable weight and min/max limits** via `config.json`
- ✅ Validates agent data (ID uniqueness, value ranges)
- 🧾 Outputs result to `output.json` including:
  - Discount amount
  - Justification for the amount
- ❌ Automatically clears or avoids writing `output.json` if validation fails
- 📂 Clean Maven project structure

---

## 🛠️ Setup Instructions

### ✅ 1. Clone or Download
```bash
git clone https://github.com/your-username/discount-allocation.git
cd discount-allocation
---

## 📝 Where to Provide Input

All input files should be placed inside the `src/main/resources/` folder:

| File         | Purpose                                     |
|--------------|---------------------------------------------|
| `input.json` | Contains the sales agents and site kitty    |
| `config.json`| Contains the allocation weights & constraints |

### 📁 Directory Structure

discount-allocation/
└── src/
└── main/
└── resources/
├── input.json ← 🔹 Your input data
└── config.json ← 🔹 Your config file
