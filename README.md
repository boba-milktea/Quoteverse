# 🌟 QuoteVerse
A simple full-stack app: a Spring Boot REST API backend and a React frontend that serves motivational and programming quotes from a JSON file.

## 🚀 Features
- Browse all quotes
- Get a random quote
- Add quotes by editing a JSON file (no database required)
- Beginner-friendly contribution flow for Hacktoberfest 🎉

## 🛠️ Backend Setup (Spring Boot)
1. Fork the repository:
   - Click the "Fork" button on the top right corner of the repository page on GitHub.

2. Clone your forked repository:
   ```bash
   git clone https://github.com/<your-username>/QuoteVerse.git
   cd QuoteVerse
   ```

3. Open the project in your favorite IDE (e.g., IntelliJ IDEA).

4. Build the project using Maven:
   ```bash
   mvn clean install
   ```

5. Run the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

6. The backend will be available at `http://localhost:8080`.

## 🌐 Frontend Setup (React)
1. Navigate to the `frontend` directory:
   ```bash
   cd frontend
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Start the React development server:
   ```bash
   npm start
   ```

4. The frontend will be available at `http://localhost:3000`.

## 🎃 Hacktoberfest Contributions
We welcome contributions from developers of all skill levels! Follow these steps to contribute:
1. Fork the repository:
   - Click the "Fork" button on the top right corner of the repository page on GitHub.

2. Clone your forked repository:
   ```bash
   git clone https://github.com/<your-username>/QuoteVerse.git
   ```

3. Create a new branch for your feature or bug fix:
   ```bash
   git checkout -b <branch-name>
   ```

4. Make your changes and commit them:
   ```bash
   git add .
   git commit -m "Your descriptive commit message"
   ```

5. Push your branch to your forked repository:
   ```bash
   git push origin <branch-name>
   ```

6. Create a pull request:
   - Go to the original repository on GitHub.
   - Click the "New Pull Request" button and select your branch.

Check out the `CONTRIBUTING.md` file for more details.

## 📂 Project Structure
```
QuoteVerse/
├── backend/       # Spring Boot backend
├── frontend/      # React frontend
├── quotes.json    # JSON file containing quotes
└── README.md      # Project documentation
```

## ⭐ Star and Fork
If you like this project, please consider giving it a ⭐ on GitHub and forking the repository to contribute or use it as a template for your own projects.

## 📜 License
This project is licensed under the MIT License. See the `LICENSE` file for details.
