let currentQuestionIndex = 0;
let questions = [];
let correctAnswers = 0;
let totalQuestions = 0;

async function fetchQuestions() {
    try {
        const token = localStorage.getItem('quizToken');
        if (!token) {
            console.warn("No token found, redirecting to login.");
            window.location.href = 'login.html';
            return;
        }

        console.log("Fetching questions with token:", token);

        const response = await fetch('http://localhost:5555/question/bySubject/java', {
            method: 'GET',
            headers: {
                'Authorization': `Bearer ${token}`,
                'Content-Type': 'application/json'
            }
        });

        if (response.status === 401 || response.status === 403) {
            console.error("Unauthorized or forbidden access");
            throw new Error("Unauthorized. Please login again.");
        }

        const rawText = await response.text();
        console.log("Raw Response Text:", rawText);

        if (!rawText.trim()) throw new Error("Empty response from server");

        let responseData;
        try {
            responseData = JSON.parse(rawText);
        } catch (e) {
            console.error("Failed to parse JSON:", rawText);
            throw new Error("Invalid server response format");
        }

        if (!responseData || !Array.isArray(responseData.data)) {
            console.warn("Unexpected or missing 'data' array:", responseData);
            throw new Error("No questions found. Please try again later.");
        }

        questions = responseData.data;
        totalQuestions = questions.length;

        console.log("Total Questions Loaded:", totalQuestions);

        if (totalQuestions > 0) {
            document.getElementById('total-questions').textContent = totalQuestions;
            displayQuestion();
        } else {
            throw new Error("No questions available for this subject.");
        }

    } catch (error) {
        console.error('Fetch Error:', error);
        document.getElementById('question-text').textContent = error.message;
        document.getElementById('options-container').innerHTML = `
            <button class="retry-btn" onclick="location.reload()">Retry</button>
        `;
    }
}

function displayQuestion() {
    if (!questions.length) return;

    const questionText = document.getElementById('question-text');
    const optionsContainer = document.getElementById('options-container');
    const currentQuestion = questions[currentQuestionIndex];

    const loadingElement = document.querySelector('.loading-state');
    if (loadingElement) loadingElement.remove();

    questionText.textContent = currentQuestion.questionTitle;
    optionsContainer.innerHTML = '';

    const options = [
        currentQuestion.option1,
        currentQuestion.option2,
        currentQuestion.option3,
        currentQuestion.option4
    ];

    options.forEach(option => {
        const button = document.createElement('button');
        button.textContent = option;
        button.className = 'option';
        button.onclick = () => checkAnswer(option);
        optionsContainer.appendChild(button);
    });

    document.getElementById('current-question').textContent = currentQuestionIndex + 1;
    document.getElementById('total-questions').textContent = questions.length;
}

function checkAnswer(selectedOption) {
    const currentQuestion = questions[currentQuestionIndex];
    if (selectedOption === currentQuestion.rightAnswer) {
        correctAnswers++;
    }
    nextQuestion();
}

function nextQuestion() {
    if (currentQuestionIndex < questions.length - 1) {
        currentQuestionIndex++;
        displayQuestion();
    } else {
        localStorage.setItem('quizScore', correctAnswers);
        localStorage.setItem('totalQuestions', totalQuestions);
        window.location.href = 'result.html';
    }
}

window.onload = fetchQuestions;