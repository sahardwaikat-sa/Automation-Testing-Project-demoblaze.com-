<div align="left">

# 🛒 Demoblaze Automation Testing

### Automated UI test suite for the Demoblaze online phone store

## 📌 Overview

This project is the automation test suite for **[Demoblaze](https://www.demoblaze.com)**, an online phone store. It uses **Java, Selenium and TestNG** to verify the main features of the site through automated UI tests, structured with the **Page Object Model**.

| | |
|---|---|
| 📄 **Document** | Test Plan: Demoblaze Automation Testing |
| 🌐 **Application** | https://www.demoblaze.com |
| 🗂️ **Jira key** | `ATHDC` |
| 📌 **Version** | 1.0 (Final) |
| 📅 **Date** | 1 October 2026 |
| ⏱️ **Duration** | 3 days |

## 🎯 Objective

Verify that the main features of Demoblaze (account sign up, login, logout, cart, and ordering) work correctly, using automated UI tests written in Java with Selenium and TestNG.

## 🔭 Scope

<table>
<tr>
<th>✅ In Scope</th>
<th>🚫 Out of Scope</th>
</tr>
<tr>
<td valign="top">

**Workflow 1: Cart and Order**
- Login
- Select items
- Check items
- Add to cart
- Verify total price
- Place order
- Checkout

**Workflow 2: Authentication and Navigation**
- Sign up
- Sign in
- Laptop category
- Next and previous pages
- Contact and send message
- Logout

</td>
<td valign="top">

- Performance and load testing
- Security testing
- Mobile and cross-browser testing (single browser only: **Microsoft Edge**)
- About Us page and video pop-ups

</td>
</tr>
</table>

## 🧪 Test Approach

| Area | Approach |
|:-----|:---------|
| **Test type** | Functional testing, automated (UI) |
| **Design pattern** | Page Object Model, with a separate page class and test class for each workflow |
| **Tools** | Java 17, Selenium 4, TestNG, Maven, IntelliJ IDEA or Eclipse |
| **Execution** | `mvn test`, or the `testng.xml` suite |
| **Reporting** | TestNG HTML report (`target/surefire-reports/index.html`) |

## 🖥️ Test Environment

| Item | Detail |
|:-----|:-------|
| **Browser** | Microsoft Edge |
| **Operating system** | Windows 10 / 11 |
| **Test URL** | https://www.demoblaze.com |
| **Username** | Random, in the form `user<timestamp>` |
| **Password** | `Test@1234` |
| **Product** | Samsung galaxy s6 |

## 🚀 Quick Start

### Prerequisites

- ☕ Java 17
- 📦 Maven
- 🌐 Microsoft Edge
- 💻 IntelliJ IDEA or Eclipse

### Installation

```bash
git clone <your-repository-url>
cd <your-project-folder>
mvn clean install -DskipTests
```

### ▶️ Run the tests

```bash
# Run all tests
mvn test

# Or run the TestNG suite file
mvn test -DsuiteXmlFile=testng.xml
```

### 📈 View the report

```text
target/surefire-reports/index.html
```

## 🏗️ Project Structure

```text
<project-folder>/
├── 📄 pom.xml            # Maven dependencies and build config
├── 📄 testng.xml         # TestNG suite
├── 📄 README.md
├── 📁 screenshots/       # Screenshots captured during runs
└── 📁 src/
    ├── pages/            # One page class per workflow (locators + actions)
    └── tests/            # One test class per workflow
```

> 💡 Adjust folder and package names to match your actual repository.

## 🚦 Entry & Exit Criteria

<table>
<tr>
<th>🟢 Entry Criteria</th>
<th>🔴 Exit Criteria</th>
</tr>
<tr>
<td valign="top">

- The Demoblaze site is reachable
- The test environment and project are set up
- Test cases are written and reviewed

</td>
<td valign="top">

- All 13 tests have been executed
- All High priority tests pass
- Any failed test is analyzed and logged as a defect or a known issue

</td>
</tr>
</table>

## 📅 Schedule

| Day | Activity | Jira Tasks |
|:---:|:---------|:----------:|
| **Day 1** | Set up the project, explore the site, write the test cases, and automate Workflow 1 | `ATHDC-1` – `ATHDC-4` |
| **Day 2** | Automate Workflow 2, refactor to Page Object Model, and add `testng.xml` | `ATHDC-5` – `ATHDC-7` |
| **Day 3** | Run the full suite, add screenshots and reports, fix flaky tests, and write the README | `ATHDC-8` – `ATHDC-11` |

## ⚠️ Risks & Assumptions

### Risks

| Risk | Mitigation |
|:-----|:-----------|
| Demoblaze is a shared demo site and can be slow or change | Use explicit waits and re-run failed tests |
| Alert messages or prices may change | Verify them manually before writing assertions |
| Random usernames could collide (rare) | Use a timestamp in every username |

### Assumptions

- The site stays available during testing
- The sign up and cart features work as they normally do

## 📦 Deliverables

- [x] Test plan
- [x] Test case list
- [x] Automation project (Java, Maven, TestNG)
- [x] TestNG execution report
- [x] README file

## 👤 sahar

<div align="center">

**<sahar>**


www.linkedin.com/in/sahar-dwikat
⭐ *If you found this project useful, give it a star!* ⭐

</div>
