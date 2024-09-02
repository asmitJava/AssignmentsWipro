document.addEventListener('DOMContentLoaded', function () {
    const registrationForm = document.getElementById('registrationForm');
    const loginForm = document.getElementById('loginForm');
    const showLoginButton = document.getElementById('showLogin');
    const showRegisterButton = document.getElementById('showRegister');

    showLoginButton.addEventListener('click', function () {
        registrationForm.style.display = 'none';
        loginForm.style.display = 'block';
    });

    showRegisterButton.addEventListener('click', function () {
        loginForm.style.display = 'none';
        registrationForm.style.display = 'block';
    });

    registrationForm.addEventListener('submit', function (event) {
        event.preventDefault();
        validateRegistrationForm();
    });

    loginForm.addEventListener('submit', function (event) {
        event.preventDefault();
        validateLoginForm();
    });

    function validateRegistrationForm() {
        const username = document.getElementById('username').value;
        const email = document.getElementById('email').value;
        const password = document.getElementById('password').value;
        const confirmPassword = document.getElementById('confirmPassword').value;

        if (username === '' || email === '' || password === '' || confirmPassword === '') {
            alert('All fields are required.');
            return false;
        }

        if (password !== confirmPassword) {
            alert('Passwords do not match.');
            return false;
        }

        alert('Registration successful!');
        return true;
    }

    function validateLoginForm() {
        const username = document.getElementById('loginUsername').value;
        const password = document.getElementById('loginPassword').value;

        if (username === '' || password === '') {
            alert('Both fields are required.');
            return false;
        }

        alert('Login successful!');
        return true;
    }
});