document.addEventListener('DOMContentLoaded', () => {
  const registrationForm = document.querySelector('form');

  registrationForm.addEventListener('submit', async (e) => {
    e.preventDefault();

    const formData = {
      fname: document.getElementById('firstName').value,
      lname: document.getElementById('lastName').value,
      email: document.getElementById('email').value,
      mobileNumber: document.getElementById('mobileNumber').value,
      password: document.getElementById('password').value
    };

    try {
      const response = await fetch('http://localhost:5555/public/register', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
      });

      const responseData = await response.json();


      if (response.status !== 201) {
        throw new Error(responseData.message || `Registration failed: ${response.status}`);
      }

      if (responseData.data?.token) {
        localStorage.setItem('quizToken', responseData.data.token)
        window.location.href = 'index.html';
      } else {
        throw new Error('Token not found in response');
      }
    } catch (error) {
      alert(error.message);
      console.error('Registration Error:', error);
    }
  });
});