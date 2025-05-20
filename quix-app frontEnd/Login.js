document.addEventListener('DOMContentLoaded', () => {
  const loginForm = document.querySelector('form');

  loginForm.addEventListener('submit', async (e) => {
    e.preventDefault();

    const formData = {
      email: document.getElementById('email').value,
      password: document.getElementById('password').value
    };

    console.log('Submitting login form with data:', formData);

    try {
      const response = await fetch('http://localhost:5555/public/login', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
      });

      console.log('Received response:', response);

      if (!response.ok) {
        const errorData = await response.json().catch(() => null);
        console.error('Server responded with error:', errorData);
        throw new Error(errorData?.message || `Login failed: ${response.status}`);
      }

      const responseData = await response.json();

      console.log('Parsed JSON response:', responseData);
      const token = responseData?.data?.token;

      if (token) {
        localStorage.setItem('quizToken', token);
        console.log('Stored token:', token);
        window.location.href = 'index.html';

      } else {
        throw new Error('Authentication token missing in response');
      }
    } catch (error) {
      alert(error.message);
      console.error('Login Error:', error);
      localStorage.removeItem('quizToken');
    }
  });
});